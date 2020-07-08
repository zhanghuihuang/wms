package com.zhanghh.wms.account.service.impl;

import com.zhanghh.wms.account.mapper.AccountMapper;
import com.zhanghh.wms.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author zhanghuihuang
 * @since 2020/7/8 3:00 下午
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public void debit(String userId, int money) {
        int i = accountMapper.updateMoney(userId, money);
        if (i != 1) {
            throw new RuntimeException("更新账户金额失败:用户不存在或金额不足");
        }
    }
}
