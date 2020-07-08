package com.zhanghh.wms.inventory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhanghh.wms.inventory.api.InventoryDto;
import com.zhanghh.wms.inventory.entity.Inventory;
import com.zhanghh.wms.inventory.mapper.InventoryMapper;
import com.zhanghh.wms.inventory.service.IInventoryService;
import org.apache.servicecomb.pack.omega.transaction.annotations.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhanghuihuang
 * @since 2020-07-06
 */
@Service("inventoryService")
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements IInventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    @Transactional
    @Compensable(compensationMethod = "cancelModifyInventory")
    public void modifyInventory(InventoryDto inventoryDto) {
        Inventory inventory = this.getById(inventoryDto.getId());
        inventory.setQuantity(inventory.getQuantity() - inventoryDto.getQuantity());
        this.updateById(inventory);
    }

    @Override
    @Transactional
    public void deduct(String commodityCode, int count) {
        Inventory inventory = inventoryMapper.findByProduct(commodityCode);
        inventory.setQuantity(inventory.getQuantity() - count);
        this.updateById(inventory);
    }

    @Transactional
    public void cancelModifyInventory(InventoryDto inventoryDto) {
        Inventory inventory = this.getById(inventoryDto.getId());
        inventory.setQuantity(inventory.getQuantity() + inventoryDto.getQuantity());
        this.updateById(inventory);
    }
}
