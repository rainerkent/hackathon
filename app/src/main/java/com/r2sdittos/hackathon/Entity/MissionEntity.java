package com.r2sdittos.hackathon.Entity;

import java.time.LocalDateTime;

public class MissionEntity {
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
    private String dueDate;

    public MissionEntity (String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
