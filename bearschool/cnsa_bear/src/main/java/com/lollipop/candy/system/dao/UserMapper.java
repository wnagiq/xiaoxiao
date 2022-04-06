package com.lollipop.candy.system.dao;

import com.lollipop.candy.system.domain.UserEntity;
import com.lollipop.candy.test.domain.TestModel;
import com.lollipop.candy.test.vo.TestVo;
import com.lollipop.candy.common.vo.SearchVo;

import org.apache.ibatis.annotations.Param;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author bear
 * @since 2022-02-23
 */
@DS(value="primary")
public interface UserMapper extends BaseMapper<UserEntity> {
	IPage<UserEntity> selectPagedList(@Param("page") Page<UserEntity> page, @Param("param") SearchVo vo);

}
