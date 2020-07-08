package com.zhanghh.wms.order.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author zhanghuihuang
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String orderNo;

    private String customerName;

    private String customerPhone;

    private String customerAddress;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private Integer version = 0;

    private LocalDateTime createAt;

    private String createBy;

    private LocalDateTime updateAt;

    private String updateBy;
}
