package com.example.spring_data_31_05.controller;



import com.example.spring_data_31_05.entity.FileServer;
import com.example.spring_data_31_05.entity.User;
import com.example.spring_data_31_05.service.FileServerService;
import com.example.spring_data_31_05.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileServerService fileServerService;

    @GetMapping("")
    public String getUsers(Model model) {
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/files/{id}")
    public String getFiles(@PathVariable Integer id, Model model) {
        List<FileServer> fileList = fileServerService.getFilesOfUser(id);
        model.addAttribute("fileList", fileList);
        model.addAttribute("userId", id);
        return "file_list";
    }

    // 1. Upload file
    @PostMapping("/files/{id}")
    public String uploadFile(@ModelAttribute("file") MultipartFile file, @PathVariable Integer id) {
        fileServerService.uploadFile(id, file);
        return "redirect:/api/v1/users/files/" + id;
    }
}