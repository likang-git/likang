package com.saibo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Log {

    private  Long id ;
    private  String workTime;
    private  String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//传入mapper格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")//返回页面格式
    private Date  createTime;
    private  Long  userId;
    //姓名翻译
    private  String name ;
    //当前页
    private int page;
    //页面大小
    private int limit ;
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
