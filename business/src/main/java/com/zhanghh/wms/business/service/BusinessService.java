package com.zhanghh.wms.business.service;

import com.zhanghh.wms.order.api.PushOrderDto;

public interface BusinessService {

    /**
     * 采购
     */
    void purchase(String userId, String commodityCode, int orderCount);

    Integer pushOrder(PushOrderDto pushOrderDto);
}