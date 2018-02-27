package com.s63d.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ownership {
    @Id @GeneratedValue
    private long Id;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    private Vehicle vehicle;
    @ManyToOne
    private Person person;

    public Ownership(Date startDate, Date endDate, Vehicle vehicle, Person person) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.vehicle = vehicle;
        this.person = person;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
