package org.yangdongdong.springcloud.service.api;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HiController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHello() {
        System.out.println("hi service");
        return "hi!";
    }
    
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String upload(@RequestParam("file")MultipartFile file) {
        System.out.println("名称："+file.getOriginalFilename());
        try {
            FileCopyUtils.copy(file.getBytes(),new File(file.getOriginalFilename()));
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        
    }
   
}
