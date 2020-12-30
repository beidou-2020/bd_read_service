package com.bd.read;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.bd.read"})
//扫描mapper接口
@MapperScan(value = "com.bd.read.repository")
@EnableTransactionManagement    //开启事务注解
//@EnableDiscoveryClient          // 服务提供方
public class BdReadServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdReadServiceApplication.class, args);
    }

}
