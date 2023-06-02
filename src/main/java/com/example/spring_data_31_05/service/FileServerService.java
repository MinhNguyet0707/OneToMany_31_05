package com.example.spring_data_31_05.service;



import com.example.spring_data_31_05.entity.FileServer;
import com.example.spring_data_31_05.entity.User;
import com.example.spring_data_31_05.repository.FileServerRepository;
import com.example.spring_data_31_05.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileServerService {

    @Autowired
    private FileServerRepository fileServerRepository;

    @Autowired
    private UserRepository userRepository;


    public List<FileServer> getFilesOfUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found user");
                });
        return fileServerRepository.findByUser_Id(id);
    }

    public FileServer getFileById(Integer id) {
        return fileServerRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found file");
                });
    }

    public Integer deleteFile(Integer id) {
        FileServer fileServer = fileServerRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found file");
                });
        fileServerRepository.delete(fileServer);
        return fileServer.getUser().getId();
    }

    public String uploadFile(Integer userId, MultipartFile file) {
        validateFile(file);

        // Upload file
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found user");
                });

        try {
            FileServer fileServer = FileServer.builder()
                    .type(file.getContentType())
                    .data(file.getBytes())
                    .user((com.example.spring_data_31_05.entity.User) user)
                    .build();

            fileServerRepository.save(fileServer);

            return "/api/v1/files/" + fileServer.getId();
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi upload file");
        }
    }

    public void validateFile(MultipartFile file) {
        // Validate file :
        // - Tên file
        // - Định dạng file có cho phép hay không
        // - Kiểm tra kích thước file
    }
}
