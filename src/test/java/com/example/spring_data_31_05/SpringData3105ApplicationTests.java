package com.example.spring_data_31_05;

import com.example.spring_data_31_05.entity.User;
import com.example.spring_data_31_05.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringData3105ApplicationTests {
    @Autowired
    private UserRepository userRepository;
//    @Test
//    void save_user() {
//        for (int i = 0; i < 2; i++) {
//            User user = User.builder()
//                    .name("user " + (i + 1))
//                    .build();
//            userRepository.save(user);
//        }
//    }


}
