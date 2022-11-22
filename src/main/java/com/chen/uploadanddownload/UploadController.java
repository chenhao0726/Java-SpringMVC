package com.chen.uploadanddownload;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("headImg") MultipartFile fileUpload, String username, HttpServletRequest request)throws Exception{

        System.out.println("上传文件是否为空:" + fileUpload.isEmpty());
        System.out.println("上传文件的大小（字节）:" + fileUpload.getSize());
        System.out.println("上传文件的类型:" + fileUpload.getContentType());
        System.out.println("上传表单name属性值:" + fileUpload.getName());
        System.out.println("上传文件名:" + fileUpload.getOriginalFilename());

        // 1 拿到上传文件的输入流
        InputStream is = fileUpload.getInputStream();
        // 获取文件名
        String originalFilename = fileUpload.getOriginalFilename();
        // 获取文件后缀
        String fileSubstring = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());

        // 在文件名前面添加一个随机字符串 - 解决文件名相同的情况下,被覆盖的情况
        fileSubstring = UUID.randomUUID().toString().replaceAll("-", "") + fileSubstring;
        // 文件上传地址,获取当前服务地址
        String uploadPath = request.getServletContext().getRealPath("/uploads");
        System.out.println("------------"+uploadPath);
        // 2 拿到服务器本地地址的输出流
        FileOutputStream os = new FileOutputStream(uploadPath+"/"+fileSubstring);
        // 3 将输入流复制到输出流中
        IOUtils.copy(is, os);

        // 关流
        is.close();
        os.close();
        return "upload success!!!";
    }

}
