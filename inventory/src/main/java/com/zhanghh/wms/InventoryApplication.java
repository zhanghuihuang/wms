package com.zhanghh.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhanghuihuang
 * @description <pre>
 *
 * </pre>
 * @since 2020/6/25 3:47 下午
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhanghh.wms.inventory.mapper")
public class InventoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }
}
