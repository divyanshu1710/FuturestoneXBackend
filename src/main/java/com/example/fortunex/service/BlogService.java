package com.example.fortunex.service;

import java.util.List;

import com.example.fortunex.dto.BlogDto;
import com.example.fortunex.entities.Blog;

public interface BlogService {

    public Blog saveBlog(BlogDto blogDto);
    public List<BlogDto> getAllBlogs();
    
}
