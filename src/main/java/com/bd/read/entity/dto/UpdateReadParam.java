package com.bd.read.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ToString
public class UpdateReadParam {
	
	/**
	 * 主键
	 */
	@NotNull(message = "修改阅读信息时ID不能为空")
	private Long id;
	
	/**
     * 书名
     */
	@NotEmpty(message = "修改阅读信息时书名不能为空")
    private String bookName;

    /**
     * 作者
     */
    @NotEmpty(message = "修改阅读信息时作者不能为空")
    private String author;

    /**
     * 备注
     */
    private String remark;

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

	/**
	 * 阅读截图名(存储在文件服务器上的图片路径)
	 */
	private String screenshotName;

    /**
     * 阅读内容分类
     */
    @NotNull(message = "修改阅读信息时内容分类不能为空")
    private Integer category;
}
