package com.Date;

import java.util.Date;

public class Schedule {
    private String id;
    private Date date;
    private Date startTime;
    private Date endTime;

    public Schedule(Date date, Date startDate, Date endDate, String id) {
        this.date = date;
        this.startTime = startDate;
        this.endTime = endDate;
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
