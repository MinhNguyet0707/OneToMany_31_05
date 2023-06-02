package com.example.spring_data_31_05.controller;


import com.example.spring_data_31_05.entity.FileServer;
import com.example.spring_data_31_05.service.FileServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
public class FileServerController {

    @Autowired
    private FileServerService fileServerService;

    // 2. Xem file
    @GetMapping("{id}")
    public ResponseEntity<?> readFile(@PathVariable Integer id) {
        FileServer fileServer = fileServerService.getFileById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileServer.getType()))
                .body(fileServer.getData());
    }

    // 3. Xoa file
    @DeleteMapping("/files/{id}")
    public String deleteFile(@PathVariable Integer id) {
       Integer userId =  fileServerService.deleteFile(id);
        return "file_list";
    }

}
