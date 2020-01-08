package com.saibo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserVo {
    //当前页
    private int page;
    //页面大小
    private int limit ;



    private  String name ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;



    public String getName() {
        return name;
    }


    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
