package com.zhanghh.wms.inventory.api;

/**
 * <pre>
 *
 * </pre>
 *
 * @author zhanghuihuang
 * @since 2020/7/6 5:39 下午
 */
public interface InventoryApi {

    void modifyInventory(InventoryDto inventoryDto);

    /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);
}
