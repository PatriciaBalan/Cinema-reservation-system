package com.example.cinemareservationsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private int roleId;

    private String nameRole;

    public Role() {
    }

    public Role(int roleId, String nameRole) {
        this.roleId = roleId;
        this.nameRole = nameRole;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
