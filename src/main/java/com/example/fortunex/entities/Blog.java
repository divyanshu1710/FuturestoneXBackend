package com.example.fortunex.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT") 
    private String description;


    @Lob
    private byte[] image;
}