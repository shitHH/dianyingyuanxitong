package com.wm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/10 17:56:41
 *播放本地视频文件控制器
 */
@Controller
public class FileAndVideoController {

    Logger logger = Logger.getLogger(AttentionController.class);

    @RequestMapping("/getvideo")
    @ResponseBody
    public void getVideo(HttpServletRequest request, HttpServletResponse response) {
        //视频资源存储信息
        response.reset();
        //获取从哪个字节开始读取文件
        String rangeString = request.getHeader("Range");
        try {
            //获取响应的输出流
            OutputStream outputStream = response.getOutputStream();
            File file = new File("d:\\dir\\毒液.mp4");
            if (file.exists()) {
                RandomAccessFile targetFile = new RandomAccessFile(file, "r");//"r":以只读的方式打开文本，也就意味着不能用write来操作文件
                long fileLength = targetFile.length();
                //播放
                if (rangeString != null) {
                    long range = Long.valueOf(rangeString.substring(rangeString.indexOf("=") + 1, rangeString.indexOf("-")));
                    //设置内容类型
                    response.setHeader("Content-Type", "mp4");
                    //设置此次相应返回的数据长度
                    response.setHeader("Content-Length", String.valueOf(fileLength - range));
                    //设置此次相应返回的数据范围
                    response.setHeader("Content-Range", "bytes " + range + "-" + (fileLength - 1) + "/" + fileLength);
                    //返回码需要为206，而不是200
                    response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                    //设定文件读取开始位置（以字节为单位）
                    targetFile.seek(range);
                } else {//下载
                    //设置响应头，把文件名字设置好
                    response.setHeader("Content-Disposition", "attachment; filename=毒液.mp4");
                    //设置文件长度
                    response.setHeader("Content-Length", String.valueOf(fileLength));
                    //解决编码问题
                    response.setHeader("Content-Type", "application/octet-stream");
                }


                byte[] cache = new byte[1024 * 300];
                int flag;
                while ((flag = targetFile.read(cache)) != -1) {
                    outputStream.write(cache, 0, flag);
                }
            } else {
                String message = "file: not exists";
                //解决编码问题
                response.setHeader("Content-Type", "application/json");
                outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            }
            outputStream.flush();
            outputStream.close();


        } catch (Exception e) {

        }
    }

    }