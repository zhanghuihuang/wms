package com.zhanghh.wms.order.api;

import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 *
 * </pre>
 *
 * @author zhanghuihuang
 * @since 2020/7/7 9:39 上午
 */
@Data
public class OrderItemDto implements Serializable {
    private String product;
    private Integer quantity;
}
