package com.github.maximkirko.wpserver.datamodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by Pavel on 25.09.2016.
 */
@Entity
@Table(name = "ticket")
public class Ticket implements java.io.Serializable {


    private Long id;
    //private List<Photo> violationPhotos;

//    @Column(name = "violation_id", unique = true, nullable = false, length = 15)
//    private Violation violation;


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

//    public List<Photo> getViolationPhotos() {
//        return violationPhotos;
//    }
//
//    public void setViolationPhotos(List<Photo> violationPhotos) {
//        this.violationPhotos = violationPhotos;
//    }

//    public Violation getViolations() {
//        return violation;
//    }
//
//    public void setViolations(Violation violation) {
//        this.violation = violation;
//    }

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

    public Ticket() {

    }

}
