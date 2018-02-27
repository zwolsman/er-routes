package com.s63d.domain;

import javax.persistence.*;
import java.util.HashSet;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private long Id;

    private String email;
    private String password;
    @OneToOne
    private Role role;
    @OneToMany
    private HashSet<Ownership> ownerships;

    public Person(String email, String password, Role role, HashSet<Ownership> ownerships) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.ownerships = ownerships;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public HashSet<Ownership> getOwnerships() {
        return ownerships;
    }

    public void setOwnerships(HashSet<Ownership> ownerships) {
        this.ownerships = ownerships;
    }
}
