package domain;

import java.util.Date;

public class Property {
    private Date startDate;
    private Date endDate;
    private Vehicle vehicle;
    private Person person;

    public Property(Date startDate, Date endDate, Vehicle vehicle, Person person) {
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
