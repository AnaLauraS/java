package com.example.TrabajoFinal.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="UserRoles",
            joinColumns = @JoinColumn(name ="id_user"),
            inverseJoinColumns = @JoinColumn(name="id_rol")
    )
    private Set<Rol> roles;
}