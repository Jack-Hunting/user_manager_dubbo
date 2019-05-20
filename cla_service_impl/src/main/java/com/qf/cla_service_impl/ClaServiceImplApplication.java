package com.qf.cla_service_impl;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.dao")
@DubboComponentScan("com.qf.service.impl")
public class ClaServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClaServiceImplApplication.class, args);
    }

}
