package com.zhanghh.wms.inventory.controller;

import com.zhanghh.wms.inventory.entity.Inventory;
import com.zhanghh.wms.inventory.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhanghuihuang
 * @description <pre>
 *
 * </pre>
 * @since 2020/6/25 7:39 下午
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    @Qualifier("inventoryService")
    private IInventoryService inventoryService;

    @GetMapping("/{id}")
    public ResponseEntity queryInventory(@PathVariable Integer id) {
        Inventory inventory = inventoryService.getById(id);
        return ResponseEntity.ok(inventory);
    }

    @PutMapping("/{id}/{quantity}")
    public ResponseEntity queryInventory(@PathVariable Integer id, @PathVariable Integer quantity) {
        Inventory inventory = inventoryService.getById(id);
        inventory.setQuantity(inventory.getQuantity() + quantity);
        inventoryService.updateById(inventory);
        return ResponseEntity.ok(inventory);
    }
}
