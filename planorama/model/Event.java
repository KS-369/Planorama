package com.mycompany.planorama.model;

public class Event {
    private String title;
    private String date;
    private String description;

    public Event(String t, String d, String desc) {
        this.title = t;
        this.date = d;
        this.description = desc;
    }

    public void setEvent(String t, String d, String desc) {
        this.title = t;
        this.date = d;
        this.description = desc;
    }
    
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
