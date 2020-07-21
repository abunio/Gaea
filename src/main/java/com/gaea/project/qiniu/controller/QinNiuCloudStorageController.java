package com.gaea.project.qiniu.controller;

import com.gaea.framework.web.domain.AjaxResult;
import com.gaea.project.qiniu.service.IQinNiuCloudStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Description
 * @Author huangW
 * @Date 9:33 2020/6/30
 * @Version 1.0
 */
@RestController
@RequestMapping("/qiniu")
public class QinNiuCloudStorageController {

    @Autowired
    private IQinNiuCloudStorageService iQinNiuCloudStorageService;

    @PostMapping("upload")
    public AjaxResult upload(MultipartFile file) throws Exception {
        return AjaxResult.success("操作成功",iQinNiuCloudStorageService.upload(file.getBytes(), file.getOriginalFilename()));
    }

}
