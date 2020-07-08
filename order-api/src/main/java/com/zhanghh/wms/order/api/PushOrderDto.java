package com.zhanghh.wms.order.api;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author zhanghuihuang
 * @since 2020/7/7 9:37 上午
 */
@Data
public class PushOrderDto implements Serializable {
    private String orderNo;

    private String customerName;

    private String customerPhone;

    private String customerAddress;

    private List<OrderItemDto> orderItems;
}
