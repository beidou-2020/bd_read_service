package com.bd.read.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@ToString
public class AddReadParam {
	
	/**
     * 书名
     */
	@NotEmpty(message = "添加阅读信息时书名不能为空")
    private String bookName;

    /**
     * 作者
     */
    @NotEmpty(message = "添加阅读信息时作者不能为空")
    private String author;

    /**
     * 备注
     */
    private String remark;
    
    /**
     * 开始阅读时间
     */
    private Date begintime;

    /**
     * 结束阅读时间
     */
    private Date endtime;
    
    /**
     * 阅读标志：1在读、2读完、3待读
     */
    private Integer readFlag;

	/**
	 * 阅读截图名(存储在文件服务器上的图片路径)
	 */
	private String screenshotName;
    
}
