package com.gabriel.springboot.app.dailyitineraries.dtos.request;

import com.gabriel.springboot.app.dailyitineraries.entities.enums.Priority;

import java.util.Date;

public class ItineraryRequestDTO {
    private String title;
    private String description;
    private Date date;
    private Priority priority;
    private Long userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
