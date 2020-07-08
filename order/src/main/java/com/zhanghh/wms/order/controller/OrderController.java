package com.zhanghh.wms.order.controller;


import com.zhanghh.wms.order.entity.Order;
import com.zhanghh.wms.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhanghuihuang
 * @since 2020-07-06
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    @Qualifier("orderService")
    private IOrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity queryOrder(@PathVariable Integer id) {
        Order order = orderService.getById(id);
        return ResponseEntity.ok(order);
    }
}
