package com.zhanghh.wms.inventory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
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
@TableName("t_wms_inventory")
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String product;

    private Integer quantity;

    private String location;

    @Version
    private Integer version;

    private LocalDateTime createAt;

    private String createBy;

    private LocalDateTime updateAt;

    private String updateBy;


}
