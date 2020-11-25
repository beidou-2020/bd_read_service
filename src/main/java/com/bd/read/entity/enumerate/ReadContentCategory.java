package com.bd.read.entity.enumerate;

/**
 * 阅读内容分类
 */
public enum ReadContentCategory {

    ADD_MENTAL_AURA(1, "补气"),
    FROFESSION(2, "专业")
    ;

    private Integer code;
    private String categoryMsg;

    ReadContentCategory(Integer code, String categoryMsg) {
        this.code = code;
        this.categoryMsg = categoryMsg;
    }
}
