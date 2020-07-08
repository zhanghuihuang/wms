package com.zhanghh.wms.inventory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhanghh.wms.inventory.entity.Inventory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhanghuihuang
 * @since 2020-07-06
 */
public interface InventoryMapper extends BaseMapper<Inventory> {
    @Select("select * from t_wms_inventory where product = #{product}")
    Inventory findByProduct(@Param("product") String product);
}
