package com.zhanghh.wms.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@TableName("t_wms_account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private int money;
}
