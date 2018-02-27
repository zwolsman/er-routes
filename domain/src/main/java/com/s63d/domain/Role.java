package com.s63d.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private long Id;

    @OneToMany
    private HashSet<Permission> permissions;

    public Role(HashSet<Permission> permissions) {
        this.permissions = permissions;
    }

    public HashSet<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(HashSet<Permission> permissions) {
        this.permissions = permissions;
    }
}
