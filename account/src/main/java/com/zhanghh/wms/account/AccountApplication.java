package com.zhanghh.wms.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * <pre>
 *
 * </pre>
 *
 * @author zhanghuihuang
 * @since 2020/7/8 2:56 下午
 */
@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
@MapperScan(basePackages = "com.zhanghh.wms.account.mapper")
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
