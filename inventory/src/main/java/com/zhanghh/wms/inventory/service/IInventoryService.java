package com.zhanghh.wms.inventory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhanghh.wms.inventory.api.InventoryApi;
import com.zhanghh.wms.inventory.entity.Inventory;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhanghuihuang
 * @since 2020-07-06
 */
public interface IInventoryService extends IService<Inventory>, InventoryApi {

}
