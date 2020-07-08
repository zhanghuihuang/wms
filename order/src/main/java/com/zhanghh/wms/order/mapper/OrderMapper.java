package com.zhanghh.wms.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhanghh.wms.order.entity.Order;
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
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from t_wms_order where order_no = #{orderNo}")
    Order findByOrderNo(@Param("orderNo") String orderNo);
}
