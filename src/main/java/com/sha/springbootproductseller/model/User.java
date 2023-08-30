package com.sha.springbootproductseller.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@Table(name = "users")
@Entity //when we say entity, this class will be a java persistence API entity,
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true,nullable = false,length = 100)
    private String userName;

    @Column(name = "passowrd", nullable = false )
    private String password;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private Role role;
}
