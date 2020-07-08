package com.zhanghh.wms.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhanghh.wms.account.api.AccountApi;
import com.zhanghh.wms.order.api.OrderDto;
import com.zhanghh.wms.order.api.OrderItemDto;
import com.zhanghh.wms.order.api.PushOrderDto;
import com.zhanghh.wms.order.entity.Order;
import com.zhanghh.wms.order.entity.OrderList;
import com.zhanghh.wms.order.mapper.OrderListMapper;
import com.zhanghh.wms.order.mapper.OrderMapper;
import com.zhanghh.wms.order.service.IOrderService;
import org.apache.servicecomb.pack.omega.transaction.annotations.Compensable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhanghuihuang
 * @since 2020-07-06
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderListMapper orderListMapper;
    @Autowired
    private ModelMapper modelMapper;

    private AccountApi accountApi;

    private static Map<String, BigDecimal> commodityMap = new HashMap<>();

    static {
        commodityMap.put("p1", new BigDecimal(10));
        commodityMap.put("p2", new BigDecimal(20));
        commodityMap.put("p3", new BigDecimal(30));
        commodityMap.put("p4", new BigDecimal(40));
        commodityMap.put("p5", new BigDecimal(50));
    }

    @Override
    @Transactional
    public OrderDto create(String userId, String commodityCode, int orderCount) {
        int orderMoney = calculate(commodityCode, orderCount);
        accountApi.debit(userId, orderMoney);

        Order order = new Order();
        order.setCustomerName(userId);
        order.setTotalQuantity(orderCount);
        order.setTotalPrice(new BigDecimal(orderMoney));
        orderMapper.insert(order);
        OrderList orderList = new OrderList();
        orderList.setOrderId(order.getId());
        orderList.setPrice(new BigDecimal(orderMoney));
        orderList.setProduct(commodityCode);
        orderList.setQuantity(orderCount);
        return modelMapper.map(order, OrderDto.class);
    }

    private int calculate(String commodityCode, int orderCount) {
        if (orderCount <= 0) {
            throw new RuntimeException("至少需要1个商品");
        }
        BigDecimal bigDecimal = commodityMap.get(commodityCode);
        if (bigDecimal != null) {
            return bigDecimal.intValue() * orderCount;
        }
        throw new RuntimeException("找不到商品");
    }

    @Override
    @Transactional
    @Compensable(compensationMethod = "cancelPushOrder")
    public OrderDto pushOrder(PushOrderDto pushOrderDto) {
        Order order = modelMapper.map(pushOrderDto, Order.class);
        order.setTotalPrice(new BigDecimal(0));
        order.setTotalQuantity(0);
        orderMapper.insert(order);
        List<OrderItemDto> orderItems = pushOrderDto.getOrderItems();
        if (orderItems != null && orderItems.size() > 0) {
            orderItems.forEach(orderItemDto -> {
                Integer quantity = orderItemDto.getQuantity();
                if (quantity == null || quantity <= 0) {
                    return;
                }
                order.setTotalQuantity(order.getTotalQuantity() + quantity);
                OrderList orderList = modelMapper.map(orderItemDto, OrderList.class);
                orderList.setOrderId(order.getId());
                orderListMapper.insert(orderList);
            });
        }
        orderMapper.updateById(order);
        return modelMapper.map(order, OrderDto.class);
    }

    public OrderDto cancelPushOrder(PushOrderDto pushOrderDto) {
        Order order = orderMapper.findByOrderNo(pushOrderDto.getOrderNo());
        if (order != null) {
            orderMapper.deleteById(order.getId());
            Map<String, Object> columnMap = new HashMap<>();
            columnMap.put("order_id", order.getId());
            orderListMapper.deleteByMap(columnMap);
        }
        return null;
    }
}
