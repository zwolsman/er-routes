package com.s63d.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Cartracker {
    @Id @GeneratedValue
    private long Id;
    @Column(unique = true)
    private String serialNumber;

    public Cartracker(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
