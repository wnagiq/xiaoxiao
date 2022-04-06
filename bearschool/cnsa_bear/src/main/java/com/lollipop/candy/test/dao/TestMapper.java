package com.lollipop.candy.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lollipop.candy.test.domain.DmTestModel;
import com.lollipop.candy.test.domain.TestModel;
import com.lollipop.candy.test.vo.TestVo;

@DS(value = "primary")
public interface TestMapper extends BaseMapper<TestModel> {

	IPage<TestModel> selectPagedList(@Param("page") Page<TestModel> page, @Param("param") TestVo vo);

	List<TestModel> selectList(@Param("page") Page<TestModel> page);

	void saveToken(@Param("token") DmTestModel m);

	List<DmTestModel> selectDmTestList();

	void updateSalt(@Param("dm_test") DmTestModel m);

}

