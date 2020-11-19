package com.bd.read.entity.query;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ReadQuery {
	
	/**
     * 书名
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;
    
    /**
     * 阅读标志：1在读、2读完、3待读
     */
    private Integer readFlag;

    /**
     * 开始阅读时间
     */
    private Date begintime;

    /**
     * 结束阅读时间
     */
    private Date endtime;
    
}
