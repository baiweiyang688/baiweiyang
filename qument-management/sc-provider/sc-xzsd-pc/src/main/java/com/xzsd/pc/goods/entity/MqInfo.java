package com.xzsd.pc.goods.entity;

public class MqInfo {
    /**
     * MQ编号
     */
    private String code;
    /**
     * 新增商品信息
     */
    private String content;
    /**
     * 新增时间
     */
    private String create_time;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
