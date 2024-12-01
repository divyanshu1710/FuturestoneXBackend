package com.example.fortunex.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.fortunex.dto.BlogDto;
import com.example.fortunex.service.BlogService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/blogs")   
public class BlogController {
    @Autowired
    private BlogService blogService;

        @PostMapping
        public ResponseEntity<String> createBlog(
                @RequestParam("title") String title,
                @RequestParam("description") String description,
                @RequestParam("image") MultipartFile image
        ) throws IOException {
            BlogDto blogDto = new BlogDto();
            blogDto.setTitle(title);
            blogDto.setDescription(description);
            blogDto.setImage(image.getBytes());
            blogService.saveBlog(blogDto);
            return ResponseEntity.ok("Blog created successfully!");
        }

    @GetMapping
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }
}