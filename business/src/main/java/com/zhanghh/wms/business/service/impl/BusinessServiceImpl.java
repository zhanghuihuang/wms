package com.zhanghh.wms.business.service.impl;

import com.zhanghh.wms.business.service.BusinessService;
import com.zhanghh.wms.inventory.api.InventoryApi;
import com.zhanghh.wms.inventory.api.InventoryDto;
import com.zhanghh.wms.order.api.OrderApi;
import com.zhanghh.wms.order.api.OrderDto;
import com.zhanghh.wms.order.api.PushOrderDto;
import org.apache.servicecomb.pack.omega.context.annotations.SagaStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private InventoryApi inventoryApi;
    @Autowired
    private OrderApi orderApi;

    /**
     * 采购
     */
    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {
        inventoryApi.deduct(commodityCode, orderCount);
        orderApi.create(userId, commodityCode, orderCount);
    }

    @Override
    @SagaStart(timeout = 60000)
    public Integer pushOrder(PushOrderDto pushOrderDto) {
        OrderDto orderDto = orderApi.pushOrder(pushOrderDto);
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setQuantity(orderDto.getTotalQuantity());
        inventoryDto.setId(2);
        inventoryApi.modifyInventory(inventoryDto);
        //模拟事务起始异常
        //int zero = 10 / 0;
        return orderDto.getId();
    }
}