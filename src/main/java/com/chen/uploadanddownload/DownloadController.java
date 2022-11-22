package com.chen.uploadanddownload;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

@Controller
public class DownloadController {

    @RequestMapping("/download")
    public void download(String name, HttpServletRequest request, HttpServletResponse response)throws Exception{
        // 1 通过传递过来的文件名,获取到服务器本地的文件
        String downloadPath = request.getServletContext().getRealPath("/uploads");
        File file = new File(downloadPath, name);
        if(file.exists()){
            // 2 拿到服务器本地文件的输入流
            FileInputStream fis = new FileInputStream(file);

            //2.1.中文文件名称处理（ie和edge都是微软的浏览器 -- 处理方式一样）
            //区分浏览器,User-Agent中有浏览器的信息，trident是ie引擎名称，具体：
            //mozilla/5.0 (windows nt 6.2; win64; x64; trident/7.0; rv:11.0) like gecko【eclipse自带ie浏览器】
            //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)
                        //Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763【电脑安装的edge浏览器】
            //mozilla/5.0 (windows nt 10.0; win64; x64; rv:68.0) gecko/20100101 firefox/68.0【火狐】
            //mozilla/5.0 (windows nt 10.0; win64; x64) applewebkit/537.36 (khtml, like gecko) chrome/73.0.3683.86 safari/537.36【谷歌】
            //ie浏览器
            if(request.getHeader("User-Agent").toUpperCase().indexOf("TRIDENT")!=-1){
                name = URLEncoder.encode(name, "utf-8");
                //电脑自带edge【edʒ】浏览器
            }else if(request.getHeader("User-Agent").toUpperCase().indexOf("EDGE")!=-1){
                name = URLEncoder.encode(name, "utf-8");
            }else{//其他浏览器
                name = new String(name.getBytes("UTF-8"),"ISO-8859-1");//转码的方式
            };

            // 设置响应的头 表明要做下载操作  下载后的文件名就是当前文件的名字
            response.setHeader("Content-Disposition", "attachment; filename=" + name);

            // 3 将输入流复制给response的输出流
            ServletOutputStream os = response.getOutputStream();
            IOUtils.copy(fis, os);

            // 4 关流
            fis.close();
            os.close();
        }
    }

}
