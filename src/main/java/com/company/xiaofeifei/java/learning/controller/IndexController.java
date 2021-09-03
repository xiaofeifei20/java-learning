package com.company.xiaofeifei.java.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring boot 接口
 * @author zouzy
 * @date 2019-12-25
 */
@RestController
public class IndexController {

    private static Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/hello")
    public String index() {
        return "hello world";
    }

    @RequestMapping(value = "/page/one", method = {RequestMethod.GET, RequestMethod.POST})
    public String userManger() {
        log.info("welcome to page one");
        return "this is page one, you can do anything...";
    }
}
