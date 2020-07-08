package com.zhanghh.wms.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

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
@TableName("t_wms_order_list")
public class OrderList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String product;

    private BigDecimal price;

    private Integer quantity;

    private Integer orderId;
}
