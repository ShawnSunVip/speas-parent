package com.sun.speas.controller;

import com.sun.speas.po.ResponseData;
import com.sun.speas.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author sunxiang
 * @date 2020-11-17 18:50
 **/
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ResponseData getTest(@RequestParam("name")String name){
        String test = testService.getTest(name);
        return ResponseData.buildSuccessResponseDataWithData("成功",test);
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public ResponseData getTest2(@RequestParam("name")String name){
        return ResponseData.buildSuccessResponseDataNoWithData("成功");
    }

}
