package com.example.fortunex.dto;

import lombok.Data;

@Data
public class BlogDto {
    private String title;
    private String description;
    private byte[] image;
}