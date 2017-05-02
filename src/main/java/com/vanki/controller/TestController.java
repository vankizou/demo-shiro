package com.vanki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vanki on 2017/4/28.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/{path}")
    public String aa(@PathVariable("path") String path) {
        return path;
    }
}
