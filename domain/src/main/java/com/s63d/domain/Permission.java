package com.s63d.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
public class Permission {

    @Id @GeneratedValue
    private long Id;

    private String description;

    public Permission( String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
