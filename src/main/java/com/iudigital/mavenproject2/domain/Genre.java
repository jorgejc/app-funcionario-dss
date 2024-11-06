package com.iudigital.mavenproject2.domain;

import java.time.LocalDateTime;

public class Genre {
    
     private int gereId;
    private String name;

    public int getGereId() {
        return gereId;
    }

    public void setGereId(int gereId) {
        this.gereId = gereId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
