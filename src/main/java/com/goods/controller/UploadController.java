package com.goods.controller;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传控制器
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Value("${tengxun.accessKey}")
    private String accessKey;
    @Value("${tengxun.secretKey}")
    private String secretKey;
    @Value("${tengxun.area}")
    private String area;
    @Value("${tengxun.bucketName}")
    private String bucketName;
    @Value("${tengxun.path}")
    private String path;

    static String qianzui = "xzsd";

    /**
     * 上传道腾讯云服务器
     *
     * @return
     */
    @RequestMapping(value = "/tengxun", method = RequestMethod.POST)
    @ResponseBody
    public Object upload(@RequestParam(value = "file") MultipartFile file, HttpSession session) {
        if (file == null) {
            return new UploadMsg(0, "文件为空", null);
        }
//        获取文件名字
        String oldFileName = file.getOriginalFilename();

//        获取后缀名
        String eName = oldFileName.substring(oldFileName.lastIndexOf("."));

//        生成16位随机名字+后缀名
        String newFileName = UUID.randomUUID() + eName;

//        1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
//         2 设置bucket的区域
        ClientConfig clientConfig = new ClientConfig(new Region(area));
//        3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
//        bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = this.bucketName;

        /**
         *     简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
         *          大文件上传请参照 API 文档高级 API 上传
         */

        File localFile = null;
        try {
//            将 MultipartFile文件转为file类型
            localFile = File.createTempFile("temp", null);
//            上传
            file.transferTo(localFile);
//             指定要上传到 COS 上的路径
            String key = "/" + qianzui + "/" + newFileName;
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
            return new UploadMsg(1, "上传成功", this.path + putObjectRequest.getKey());
        } catch (IOException e) {
            return new UploadMsg(-1, e.getMessage(), null);
        } finally {
//            关闭客户端(关闭后台线程)
            cosclient.shutdown();
        }
    }

    private class UploadMsg {
        public int status;
        public String msg;
        public String path;

        public UploadMsg() {
            super();
        }

        public UploadMsg(int status, String msg, String path) {
            this.status = status;
            this.msg = msg;
            this.path = path;
        }

    }
}