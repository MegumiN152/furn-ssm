package com.hh.furn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 黄昊
 * @version 1.0
 **/
@Controller
public class TestController {
    @RequestMapping(value = "/hi")
    public String test(){
        System.out.println("test");
        return "test";
    }
}
