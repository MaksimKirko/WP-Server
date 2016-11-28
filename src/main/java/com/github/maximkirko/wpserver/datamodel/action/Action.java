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

    private Long id;
    private ActionEnum type;
    private String description;
    private List<Violation> violations;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "type", unique = true, nullable = false, length = 256)
    @Enumerated(EnumType.STRING)
    public ActionEnum getType() {
        return type;
    }

    public void setType(ActionEnum type) {
        this.type = type;
    }

    @Column(name = "description", nullable = false, length = 512)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "action")
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
                ", violations=" + violations +
                '}';
    }

    public Action() {

    }

    public void performAction() {

    }
}
