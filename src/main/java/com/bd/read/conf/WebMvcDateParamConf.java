package com.bd.read.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.TimeZone;

@Configuration
public class WebMvcDateParamConf implements WebMvcConfigurer {

    @Value("${spring.jackson.date-format:yyyy-MM-dd}")
    private String pattern;

    /**
     * 接收到客户端传递的时间类型的参数将其自动转换, 后台可以直接使用Date类型接受。
     * (也可直接在对象属性上加注解@DateTimeFormat(pattern = "yyyy-MM-dd")[不推荐这种方式])
     *
     * @param registry date
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        TimeZone tz = TimeZone.getTimeZone("GMT+8");
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd");
        dateFormatter.setTimeZone(tz);
        registry.addFormatter(dateFormatter);
    }
}
