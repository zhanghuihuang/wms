package com.zhanghh.wms.account.api;

public interface AccountApi {

    /**
     * 从用户账户中借出
     */
    void debit(String userId, int money);
}