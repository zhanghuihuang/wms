package com.zhanghh.wms.business.controller;

import com.zhanghh.wms.business.service.BusinessService;
import com.zhanghh.wms.order.api.PushOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author zhanghuihuang
 * @since 2020/7/8 2:45 下午
 */
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping
    public ResponseEntity pushOrder(@RequestBody PushOrderDto pushOrderDto) {
        Integer id = businessService.pushOrder(pushOrderDto);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/{userId}/{commodityCode}/{orderCount}")
    public ResponseEntity purchase(@PathVariable String userId, @PathVariable String commodityCode, @PathVariable int orderCount) {
        businessService.purchase(userId, commodityCode, orderCount);
        return ResponseEntity.ok().build();
    }
}
