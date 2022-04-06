package com.lollipop.candy.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lollipop.candy.common.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/base")
@Api(tags = "Hello", value = "HelloController")
public class HelloController extends BaseController {

    @ApiOperation(value = "Frist Try")
    @GetMapping("/all")
    public String all() {
        return "hello!";
    }
    
}
