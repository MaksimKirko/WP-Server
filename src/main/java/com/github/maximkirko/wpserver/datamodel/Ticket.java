package com.github.maximkirko.wpserver.datamodel;

import com.github.maximkirko.wpserver.datamodel.violation.Violation;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Pavel on 25.09.2016.
 */
@Entity
@Table(name = "ticket")
public class Ticket {

    private Long id;
    private Set<Photo> violationPhotos;
    private Violation violation;
    private String licensePlate;
    private String address;
    private String location;
    private Date date;
    private String comment;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ticket_2_photo", joinColumns = {
            @JoinColumn(name = "ticket_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "photo_id",
                    nullable = false, updatable = false)})
    public Set<Photo> getViolationPhotos() {
        return violationPhotos;
    }

    public void setViolationPhotos(Set<Photo> violationPhotos) {
        this.violationPhotos = violationPhotos;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "violation_id", nullable = false)
    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }

    @Column(name = "license_plate", length = 15)
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Column(name = "address", length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "coords", length = 100)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "date", length = 15)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "comment", length = 100)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tickets")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", violation=" + violation +
                ", licensePlate='" + licensePlate + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Ticket() {

    }

}
