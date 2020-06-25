package com.zhanghh.wms.inventory.service.impl;

import com.zhanghh.wms.inventory.mapper.InventoryMapper;
import com.zhanghh.wms.inventory.model.Inventory;
import com.zhanghh.wms.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhanghuihuang
 * @description <pre>
 *
 * </pre>
 * @since 2020/6/25 8:01 下午
 */
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public int deleteByPrimaryKey(String product) {
        return inventoryMapper.deleteByPrimaryKey(product);
    }

    @Override
    public int insert(Inventory record) {
        return inventoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Inventory record) {
        return inventoryMapper.insertSelective(record);
    }

    @Override
    public Inventory selectByPrimaryKey(String product) {
        return inventoryMapper.selectByPrimaryKey(product);
    }

    @Override
    public int updateByPrimaryKeySelective(Inventory record) {
        return inventoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Inventory record) {
        return inventoryMapper.updateByPrimaryKey(record);
    }
}
