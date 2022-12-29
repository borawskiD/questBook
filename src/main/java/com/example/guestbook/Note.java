package com.example.guestbook;

import java.time.LocalDateTime;

public class Note {
    private String name;
    private String context;
    private java.sql.Timestamp time;

    public Note(String name, String context) {
        this.name = name;
        this.context = context;
        this.time = java.sql.Timestamp.valueOf(LocalDateTime.now());
    }
    public Note(String name, String context, java.sql.Timestamp date) {
        this.name = name;
        this.context = context;
        this.time = date;
    }

    public String getName() {
        return name;
    }

    public String getContext() {
        return context;
    }

    public java.sql.Timestamp getTime() {
        return time;
    }
}
