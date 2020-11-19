package com.bd.read;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.bd.read"})
//扫描mapper接口
@MapperScan(value = "com.bd.read.repository")
@EnableDiscoveryClient          // 服务提供方
public class BdReadServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdReadServiceApplication.class, args);
    }

}
