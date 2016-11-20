package com.github.maximkirko.mavenwebapptest.models;

import com.github.maximkirko.mavenwebapptest.models.violations.Violation;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 25.09.2016.
 */
public class Ticket {

    private List<File> violationPhotos;
    private Violation violation;
    private String licensePlate;
    private String address;
    private Coords location;
    private Date date;
    private String comment;

    public List<File> getViolationPhotos() {
        return violationPhotos;
    }

    public void setViolationPhotos(List<File> violationPhotos) {
        this.violationPhotos = violationPhotos;
    }

    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Coords getLocation() {
        return location;
    }

    public void setLocation(Coords location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Ticket() {
    }

    public Ticket(List<File> violationPhotos, Violation violation, String licensePlate, String address, Coords location, Date date, String comment) {
        this.violationPhotos = violationPhotos;
        this.violation = violation;
        this.licensePlate = licensePlate;
        this.address = address;
        this.location = location;
        this.date = date;
        this.comment = comment;
    }
}
