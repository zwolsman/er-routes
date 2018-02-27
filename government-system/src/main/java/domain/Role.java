package domain;

import java.util.HashSet;

public class Role {
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
