package com.github.maximkirko.wpserver.datamodel;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by MadMax on 30.11.2016.
 */
@Entity
@Table(name = "role", uniqueConstraints = {
        @UniqueConstraint(columnNames = "type")})
public class Role {

    private Long id;
    private Set<User> users;
    private String type;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Column(name = "type", unique = true, nullable = false, length = 128)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public Role() {

    }
}
