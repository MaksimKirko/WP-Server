package com.github.maximkirko.wpserver.datamodel.violation;

import com.github.maximkirko.wpserver.datamodel.Ticket;
import com.github.maximkirko.wpserver.datamodel.action.Action;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Pavel on 12.10.2016.
 */

@Entity
@Table(name = "violation", uniqueConstraints = {
        @UniqueConstraint(columnNames = "type")})
public class Violation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "type", unique = true, nullable = false, length = 128)
    @Enumerated(EnumType.STRING)
    private ViolationEnum type;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @Column(name = "fee", nullable = false)
    private double fee;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "violation")
    private Set<Ticket> tickets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ViolationEnum getType() {
        return this.type;
    }

    public void setType(ViolationEnum type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Violation{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", fee=" + fee +
                '}';
    }

    public Violation() {

    }
}
