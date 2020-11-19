package com.sun.speas.service;

import org.springframework.stereotype.Service;

/**
 * @author sunxiang
 * @date 2020-11-18 13:16
 **/
@Service
public class TestService {

    public String getTest(String name){
        return "Hello,"+name;
    }
}
