package com.example.spring_data_31_05.repository;

import com.example.spring_data_31_05.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}