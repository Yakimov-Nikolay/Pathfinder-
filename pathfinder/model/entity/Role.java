package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RoleEnums;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleEnums role;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleEnums getRole() {
        return role;
    }

    public Role setRole(RoleEnums role) {
        this.role = role;
        return this;
    }
}
