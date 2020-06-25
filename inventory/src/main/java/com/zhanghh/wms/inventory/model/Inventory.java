package com.zhanghh.wms.inventory.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_inventory
 *
 * @author
 */
@Data
public class Inventory implements Serializable {
    private String product;

    private Integer quantity;

    private Date createAt;

    private String createBy;

    private Date updateAt;

    private String updateBy;
}