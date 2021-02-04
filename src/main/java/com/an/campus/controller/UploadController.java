package com.an.campus.controller;

import com.an.campus.constants.StateEnum;
import com.an.campus.dto.UploadResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@CrossOrigin
public class UploadController {
    private static String imgFilePath = "D://upload//img//";
    private static String headImgFilePath = "D://upload//head//";
    @PostMapping("/img/upload")
    public UploadResult uploadImg(@RequestParam("file") MultipartFile file){
        String fileName = file.getOriginalFilename();

        File dest = new File(imgFilePath + fileName);
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
            return new UploadResult(StateEnum.ERROR.getState(), null);
        }
        return new UploadResult(StateEnum.SUCCESS.getState(),"/images/img/" + fileName);

    }
    @PostMapping("/headImg/upload")
    public UploadResult uploadHeadImg(@RequestParam("file") MultipartFile file){

        String fileName = file.getOriginalFilename();

        File dest = new File(headImgFilePath + fileName);
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
            return new UploadResult(StateEnum.ERROR.getState(), null);
        }
        return new UploadResult(StateEnum.SUCCESS.getState(),"/images/head/" + fileName);

    }
}
