package com.example.fortunex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fortunex.entities.Users;

public interface UserRepository extends JpaRepository<Users, String> {
    Users findByUsername(String username);
}
