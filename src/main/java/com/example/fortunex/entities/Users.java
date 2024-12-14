package com.example.fortunex.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
}
