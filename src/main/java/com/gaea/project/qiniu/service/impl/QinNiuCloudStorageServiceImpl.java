package com.gaea.project.qiniu.service.impl;

import com.gaea.project.qiniu.config.QiniuConfig;
import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.IOUtils;
import com.gaea.common.utils.IdUtils;
import com.gaea.common.utils.StringUtils;
import com.gaea.project.qiniu.service.IQinNiuCloudStorageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

/**
 * @Description
 * @Author huangW
 * @Date 17:17 2020/6/29
 * @Version 1.0
 */
@Slf4j
@Service
public class QinNiuCloudStorageServiceImpl implements IQinNiuCloudStorageService {

    @Autowired
    private QiniuConfig qiniuConfig;

    @Override
    public String upload(byte[] data, String fileName) throws Exception {
        Auth auth = Auth.create(qiniuConfig.getAccessKey(), qiniuConfig.getSecretKey());
        Configuration cfg = new Configuration(Region.region2());
        UploadManager uploadManager = new UploadManager(cfg);
        String upToken = auth.uploadToken(qiniuConfig.getBucket());
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String pathName = null;
        if (checkPicture(suffix)) {
            pathName = qiniuConfig.getPathPicture() + IdUtils.simpleUUID() + suffix;
        } else {
            pathName = qiniuConfig.getPathVideo() + IdUtils.simpleUUID() + suffix;
        }
        try {
            Response res = uploadManager.put(data, pathName, upToken);
            if (!res.isOK()) {
                throw new RuntimeException("上传七牛出错：" + res.toString());
            }
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
            String pathAdd = qiniuConfig.getHttpBase() + putRet.key;
            log.info("upload上传七牛成功 -> " + pathAdd);
            return pathAdd;
        } catch (Exception ex) {
            throw new Exception(" 文件上传失败：" + ex.getMessage());
        }
    }

    @Override
    public void upload(InputStream inputStream, String fileName) throws Exception {
        upload(IOUtils.toByteArray(inputStream), fileName);
    }

    @Override
    public void upload(File file, String fileName) throws Exception {
        upload(FileUtils.readFileToByteArray(file), fileName);
    }

    @Override
    public String getBaseUrl() {
        return qiniuConfig.getHttpBase();
    }

    private boolean checkPicture(String suffix) {
        String[] pictureSuffixs = {".jpg", ".jpeg", ".png", ".gif", ".bmp", ".svg"};
        for (String picture : pictureSuffixs) {
            if (StringUtils.equalsAnyIgnoreCase(picture, suffix)) {
                return true;
            }
        }
        return false;
    }
}
