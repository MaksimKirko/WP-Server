package com.github.maximkirko.wpserver.datamodel.action;

import com.github.maximkirko.wpserver.datamodel.violation.Violation;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Pavel on 25.09.2016.
 */

@Entity
@Table(name = "action", uniqueConstraints = {
        @UniqueConstraint(columnNames = "type")})
public class Action {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "type", unique = true, nullable = false, length = 128)
    @Enumerated(EnumType.STRING)
    private ActionEnum type;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "actions", cascade = CascadeType.ALL)
    private List<Violation> violations;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActionEnum getType() {
        return type;
    }

    public void setType(ActionEnum type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

    public Action() {

    }

    public void performAction() {

    }
}
