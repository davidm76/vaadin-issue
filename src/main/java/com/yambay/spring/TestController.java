package com.yambay.spring;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class TestController {


    @GetMapping("/get")
    public String doGet() {

        return "Get works";
    }

    @PostMapping("/import")
    public String doPost(@RequestParam("file") MultipartFile file) {


        return  file.getName();
    }


    @PostMapping("/test")
    public String doTest(@RequestBody MyModel myModel) {


        return  myModel.getHello() + " " + myModel.getWorld();
    }


}