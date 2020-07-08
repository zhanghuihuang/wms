package com.zhanghh.wms.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhanghh.wms.account.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhanghuihuang
 * @since 2020-07-06
 */
public interface AccountMapper extends BaseMapper<Account> {
    @Update("update t_wms_account set money = money - #{money} where id = #{userId} and money >= #{money}")
    int updateMoney(@Param("userId") String userId, @Param("money") int money);
}
