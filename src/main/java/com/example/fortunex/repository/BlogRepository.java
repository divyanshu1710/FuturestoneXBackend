package com.example.fortunex.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fortunex.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}