package com.example.spring_data_31_05.repository;


import com.example.spring_data_31_05.entity.FileServer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileServerRepository extends JpaRepository<FileServer, Integer> {
    List<FileServer> findByUser_Id(Integer id);
}