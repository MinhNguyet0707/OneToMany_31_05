package com.example.spring_data_31_05;

import com.example.spring_data_31_05.entity.User;
import com.example.spring_data_31_05.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringData3105Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringData3105Application.class, args);
    }

}
