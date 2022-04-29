package com.demo.controller;

import com.demo.config.MinioConfig;
import com.demo.utils.AjaxResult;
import com.demo.utils.MinioUtil;
import io.minio.messages.Bucket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author yyk
 * @description: TODO
 * @date 2022/4/28  16:07
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private MinioUtil minioUtil;
    @Autowired
    private MinioConfig prop;


    @GetMapping("/bucketExists")
    public AjaxResult bucketExists(String bucketName) {
        return AjaxResult.success(minioUtil.bucketExists(bucketName));
    }


    @GetMapping("/makeBucket")
    public AjaxResult makeBucket(String bucketName) {
        minioUtil.makeBucket(bucketName);
        return AjaxResult.success();
    }


    @GetMapping("/removeBucket")
    public AjaxResult removeBucket(String bucketName) {
        minioUtil.removeBucket(bucketName);
        return AjaxResult.success();
    }


    @GetMapping("/getAllBuckets")
    public AjaxResult getAllBuckets() {
        List<Bucket> allBuckets = minioUtil.getAllBuckets();
        return AjaxResult.success(allBuckets);
    }


    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam(value = "file") MultipartFile file) {
        String objectName = minioUtil.upload(file);
        if (null != objectName) {
            return AjaxResult.success(prop.getEndpoint() + "/" + prop.getBucketName() + "/" + objectName);
        }
        return AjaxResult.error();
    }


    @GetMapping("/preview")
    public AjaxResult preview(@RequestParam("fileName") String fileName) {
        return AjaxResult.success(minioUtil.preview(fileName));
    }


    @GetMapping("/download")
    public AjaxResult download(@RequestParam("fileName") String fileName, HttpServletResponse res) {
        minioUtil.download(fileName,res);
        return AjaxResult.success();
    }


    @PostMapping("/delete")
    public AjaxResult remove(String url) {
        String objName = url.substring(url.lastIndexOf(prop.getBucketName()+"/") + prop.getBucketName().length()+1);
        minioUtil.remove(objName);
        return AjaxResult.success();
    }
}
