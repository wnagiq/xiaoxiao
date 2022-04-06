package com.lollipop.candy.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lollipop.candy.common.controller.BaseController;
import com.lollipop.candy.test.domain.TestModel;
import com.lollipop.candy.test.service.TestService;
import com.lollipop.candy.test.vo.TestVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/login")
@Api(tags = "Login", value = "LoginController")
public class LoginController extends BaseController {

	@Autowired
	private TestService testService;
	
    @ApiOperation(value = "user login system")
    @GetMapping("/")
    public String all() {
        return "hello!";
    }
    
    @ApiOperation(value = "user login system")
    @GetMapping("/page")
    public IPage<TestModel> page(TestVo vo) {
        return testService.queryPageList(vo);
    }
    
    @ApiOperation(value = "user login system")
    @GetMapping("/list")
    public List<TestModel> list(TestVo vo) {
    	return testService.queryList(vo);
    }
    
    @ApiOperation(value = "user login system")
    @GetMapping("/token")
    public String token(TestVo vo) {
    	return testService.saveToken(vo);
    }

    @ApiOperation(value = "user login system")
    @GetMapping("/salt")
    public String salt(TestVo vo) {
    	return testService.saveSalt(vo);
    }
    
}
