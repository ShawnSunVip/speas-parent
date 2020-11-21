package com.sun.speas.apicontroller;

import com.sun.speas.po.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 外部API
 * @author shawn
 * @descript
 * @create 2020-11-21 3:15 下午
 */
@RestController
@RequestMapping("/api/v1")
public class ApiTestController {

    @RequestMapping(value = "/apitest",method = RequestMethod.GET)
    public ResponseData getTest(){
        return ResponseData.buildSuccessResponseDataNoWithData("成功");
    }
}
