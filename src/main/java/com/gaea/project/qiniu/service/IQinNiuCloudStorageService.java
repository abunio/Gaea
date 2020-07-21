package com.gaea.project.qiniu.service;

import java.io.File;
import java.io.InputStream;

/**
 * @Description 云存储接口
 * @Author huangW
 * @Date 17:14 2020/6/29
 * @Version 1.0
 */
public interface IQinNiuCloudStorageService {
    /**
     * 上传文件到云存储, 返回图片HTTP地址
     * @param data 字节数据
     * @param fileName 文件名
     * @return 图片HTTP地址
     * @throws Exception
     */
    String upload(byte[] data, String fileName) throws Exception;

    /**
     * 上传文件到云存储, 返回图片HTTP地址
     * @param inputStream 字节流
     * @param fileName 文件名
     * @return 图片HTTP地址
     * @throws Exception
     */
    void upload(InputStream inputStream, String fileName) throws Exception;

    /**
     * 上传文件到云存储, 返回图片HTTP地址
     * @param file 文件
     * @param fileName 文件名
     * @return 图片HTTP地址
     * @throws Exception
     */
    void upload(File file, String fileName) throws Exception;

    String getBaseUrl();
}
