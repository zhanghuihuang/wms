package com.zhanghh.wms.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhanghh.wms.order.api.OrderApi;
import com.zhanghh.wms.order.entity.Order;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhanghuihuang
 * @since 2020-07-06
 */
public interface IOrderService extends IService<Order>, OrderApi {

}
