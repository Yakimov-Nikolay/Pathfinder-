package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.LevelEnums;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {


    private String fullName;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private LevelEnums level;
    private Set<Role> roles;

    public User() {
    }

    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Column(nullable = false,unique = true)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column
    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public LevelEnums getLevel() {
        return level;
    }

    public User setLevel(LevelEnums level) {
        this.level = level;
        return this;
    }

    @ManyToMany(fetch = FetchType.EAGER)

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }
}
