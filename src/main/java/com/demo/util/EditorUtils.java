package com.demo.util;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class EditorUtils {

    @Value("${imgPath}")
    private String imgPath;

    @Value("${realPath}")
    private String realPath;


    public String uploadImg(MultipartFile multipartFile){
        String orginalFilename = multipartFile.getOriginalFilename();
        String lastName = orginalFilename.substring(orginalFilename.lastIndexOf("."));

        String newFileName = UUID.randomUUID().toString()+lastName;

        File dir = new File(realPath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        String exec = null;

        try {
            multipartFile.transferTo(new File(dir,newFileName));
            exec = new JSONObject(resultMap("SUCCESS",orginalFilename,multipartFile.getSize(),newFileName,lastName,imgPath+newFileName)).toString();
        } catch (IOException e) {
            e.printStackTrace();
            exec = new JSONObject(resultMap("FAIL",null,0,null,null,null)).toString();
        }
        return exec;
    }
    private Map<String,Object> resultMap(String state, String original, long size, String title, String type, String url){
        Map<String ,Object> result = new HashMap<>();
        result.put("state",state);
        result.put("original",original);
        result.put("size",size);
        result.put("title",title);
        result.put("type",type);
        result.put("url", url);
        return result;
    }
}
