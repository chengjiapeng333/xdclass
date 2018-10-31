package net.xdclass.controller;

import net.xdclass.domain.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by chengjiapeng on 2018/9/2.
 */
@RestController
@PropertySource({"classpath:application.properties"})
public class FileController {

    @Value("${web.file.path}")
    private String filePath ;

    @RequestMapping("/upload")
    public Object upload(@RequestParam("head_img")MultipartFile file, HttpServletRequest request) {
        System.out.println("获取到的名称:"+filePath);
        String name = request.getParameter("name");
        System.out.println("用户名:"+name);

        String fileName = file.getOriginalFilename();
        System.out.println("文件名:"+fileName);

        String suffixName =  fileName.substring(fileName.lastIndexOf("."));
        System.out.println("文件后缀名："+suffixName);

        fileName = UUID.randomUUID()+suffixName;
        File dest = new File(filePath+fileName);

        try {
            file.transferTo(dest);
            return new JsonData(0, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonData(-1, null, "fail to save");
    }
}
