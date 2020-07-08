package com.zhanghh.wms.order.api;

public interface OrderApi {

    /**
     * 创建订单
     */
    OrderDto create(String userId, String commodityCode, int orderCount);

    OrderDto pushOrder(PushOrderDto pushOrderDto);
}