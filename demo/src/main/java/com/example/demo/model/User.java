package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @ManyToMany
    @JoinTable(
            name = "User_Role",
    joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    Set<Role> roles = new HashSet<>();

}
