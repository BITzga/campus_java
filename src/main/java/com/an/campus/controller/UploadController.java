package com.an.campus.controller;

import com.an.campus.dto.UploadResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/img")
public class UploadController {
    @PostMapping("/upload")
    public UploadResult upload(@RequestParam("file") MultipartFile file){

        return null;


    }
}
