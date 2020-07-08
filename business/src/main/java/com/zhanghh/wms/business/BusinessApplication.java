package com.zhanghh.wms.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * <pre>
 *
 * </pre>
 *
 * @author zhanghuihuang
 * @since 2020/7/8 2:54 下午
 */
@SpringBootApplication(scanBasePackages = "com.zhanghh.wms")
@ImportResource("classpath:dubbo.xml")
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
