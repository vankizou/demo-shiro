package com.zoufanqi.controller;

import com.zoufanqi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vanki on 2017/4/28.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{path}")
    public String aa(@PathVariable("path") String path) {
        return path;
    }
}
