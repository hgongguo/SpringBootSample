package com.hgg.controller;

import com.hgg.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by hgg on 2018/5/21.
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    @Autowired
    SampleService sampleService;

    @Value("${weixin.appID}")
    private String appId = "";


    @RequestMapping("/")
    @ResponseBody
    List<Map> home() {
        return sampleService.getUserInfo();
    }
    @RequestMapping("/appId")
    @ResponseBody
    String appId() {
        return appId;
    }
    @RequestMapping("/hello")
    String hello1() {
        System.out.println("H1");
        return "/hello";
    }

}
