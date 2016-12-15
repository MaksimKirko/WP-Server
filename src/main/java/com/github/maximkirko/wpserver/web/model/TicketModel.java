package com.github.maximkirko.wpserver.web.model;

import com.github.maximkirko.wpserver.datamodel.Photo;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;

import java.util.Date;
import java.util.Set;

/**
 * Created by MadMax on 15.12.2016.
 */
public class TicketModel {

    private Long id;
    private Set<Photo> violationPhotos;
    private ViolationEnum violation;
    private String licensePlate;
    private String address;
    private String location;
    private Date date;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Photo> getViolationPhotos() {
        return violationPhotos;
    }

    public void setViolationPhotos(Set<Photo> violationPhotos) {
        this.violationPhotos = violationPhotos;
    }

    public ViolationEnum getViolation() {
        return violation;
    }

    public void setViolation(ViolationEnum violation) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
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

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", violationPhotos=" + violationPhotos +
                ", violation=" + violation +
                ", licensePlate='" + licensePlate + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                '}';
    }

    public TicketModel() {

    }
}
