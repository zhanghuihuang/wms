package com.zhanghh.wms.inventory.mapper;

import com.zhanghh.wms.inventory.model.Inventory;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryMapper {
    int deleteByPrimaryKey(String product);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(String product);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);
}