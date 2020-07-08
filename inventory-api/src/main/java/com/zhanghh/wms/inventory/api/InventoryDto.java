package com.zhanghh.wms.inventory.api;

import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 *
 * </pre>
 *
 * @author zhanghuihuang
 * @since 2020/7/6 5:39 下午
 */
@Data
public class InventoryDto implements Serializable {
    private Integer id;

    private Integer quantity;
}
