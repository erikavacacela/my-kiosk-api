package com.my.kiosk.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", length = 100, nullable = false)
    private String first_name;

    @Column(name = "last_name", length = 100, nullable = false)
    private String last_name;

    @Column(name = "email", length = 60, nullable = false)
    private String email;

    @Column(name = "username", length = 20, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @OneToMany(mappedBy="user")
    private Set<Account> accountSet;

}
