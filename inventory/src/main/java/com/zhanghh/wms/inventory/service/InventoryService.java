package com.zhanghh.wms.inventory.service;

import com.zhanghh.wms.inventory.model.Inventory;

/**
 * @author zhanghuihuang
 * @description <pre>
 *
 * </pre>
 * @since 2020/6/25 8:01 下午
 */
public interface InventoryService {
    int deleteByPrimaryKey(String product);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(String product);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);
}
