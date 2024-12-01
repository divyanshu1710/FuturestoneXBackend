package com.example.fortunex.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fortunex.dto.BlogDto;
import com.example.fortunex.entities.Blog;
import com.example.fortunex.repository.BlogRepository;
import com.example.fortunex.service.BlogService;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog saveBlog(BlogDto blogDto) {

        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setDescription(blogDto.getDescription());
        blog.setImage(blogDto.getImage());
        return blogRepository.save(blog);
    }

    @Override
    public List<BlogDto> getAllBlogs() {

        return blogRepository.findAll()
                .stream()
                .map(blog -> {
                    BlogDto blogDto = new BlogDto();
                    blogDto.setTitle(blog.getTitle());
                    blogDto.setDescription(blog.getDescription());
                    blogDto.setImage(blog.getImage());
                    return blogDto;
                })
                .collect(Collectors.toList());
    }
    
}
