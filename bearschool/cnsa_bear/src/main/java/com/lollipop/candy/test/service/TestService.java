package com.lollipop.candy.test.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lollipop.candy.test.domain.TestModel;
import com.lollipop.candy.test.vo.TestVo;

public interface TestService extends IService<TestModel> {

	IPage<TestModel> queryPageList(TestVo vo);

	List<TestModel> queryList(TestVo vo);

	String saveToken(TestVo vo);

	String saveSalt(TestVo vo);

}
