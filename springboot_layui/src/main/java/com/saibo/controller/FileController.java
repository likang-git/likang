package com.saibo.controller;


import com.saibo.base.BaseController;
import com.saibo.base.CommonUtil;
import com.saibo.model.SysFile;
import com.saibo.service.SysFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


@Controller
public class FileController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Resource
    private SysFileService sysFileService;

    @RequestMapping("/setFeil")
    public String upload() {
        return "upload";
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws Exception {
        //这里如果没有设置路径的话，会默认保存在项目根目录下
        String filePath = file.getOriginalFilename();
        String path = "E:/imgING/";
        SysFile sysFile = new SysFile();
        sysFile.setFileName(filePath);
        sysFile.setUrl(path+filePath);
        sysFile.setId(CommonUtil.uuid());
        sysFileService.save(sysFile);
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path+filePath));
        outputStream.write(file.getBytes());
        outputStream.flush();
        outputStream.close();
        return "sysFileList";
    }
    @RequestMapping("/sysFileAll")
    @ResponseBody
    public  Object  list(){
        List<SysFile>  sysFiles = sysFileService.getAll();
        return success(sysFiles);
    }


    @RequestMapping("/down")
    public ResponseEntity download(String id) throws IOException {
        SysFile sysFile = sysFileService.getById(id);
        FileSystemResource fike = new FileSystemResource(sysFile.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment; filename="+ URLEncoder.encode(sysFile.getFileName(),"UTF-8"));
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(fike.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-strem"))
                .body(new InputStreamResource(fike.getInputStream()));
    }

    @RequestMapping("/uploads")
    @ResponseBody
    public void uploads(MultipartFile file) {
        String filePath = file.getOriginalFilename();
        String path = "E:/imgING/";
        File dest = new File(path + filePath);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}