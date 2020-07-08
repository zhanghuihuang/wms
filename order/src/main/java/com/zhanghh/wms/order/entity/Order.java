package com.zhanghh.wms.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
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
@TableName("t_wms_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String orderNo;

    private String customerName;

    private String customerPhone;

    private String customerAddress;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    @Version
    private Integer version = 0;

    private LocalDateTime createAt;

    private String createBy;

    private LocalDateTime updateAt;

    private String updateBy;


}
