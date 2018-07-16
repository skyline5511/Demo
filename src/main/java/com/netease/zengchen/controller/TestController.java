package com.netease.zengchen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XuQiang
 */
@RestController
public class TestController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        return "Welcome to mini4 project.";
    }
}
