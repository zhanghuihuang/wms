package com.zhanghh.wms.inventory.controller;

import com.zhanghh.wms.inventory.model.Inventory;
import com.zhanghh.wms.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private InventoryService inventoryService;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/{product}")
    public Inventory getInventoryInfo(@PathVariable String product) {
        return inventoryService.selectByPrimaryKey(product);
    }

    @GetMapping("/cache")
    public Inventory getCacheInventoryInfo() {
        Inventory inventory = inventoryService.selectByPrimaryKey("goods1");
        redisTemplate.opsForValue().set("goods1", inventory);
        return (Inventory) redisTemplate.opsForValue().get("goods1");
    }
}
