package com.lollipop.candy.system.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lollipop.candy.common.annotation.Log;
import com.lollipop.candy.common.controller.ApiResponseInfo;
import com.lollipop.candy.common.controller.BaseController;
import com.lollipop.candy.common.domain.QueryRequest;
import com.lollipop.candy.common.exception.BearException;
import com.lollipop.candy.system.domain.UserEntity;
import com.lollipop.candy.system.service.UserService;
import com.lollipop.candy.test.service.TestService;
import com.lollipop.candy.common.vo.SearchVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author bear
 * @since 2022-02-23
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "用户表", description = "用户表", tags = "用户表")
public class UserControlller extends BaseController {

    @Autowired
    private UserService userService;

	@Log("用户表分页列表")
    @ApiOperation(value = "用户表分页列表")
    @GetMapping(value = "/page")
    public ApiResponseInfo<IPage<UserEntity>> getPagedList(QueryRequest query, SearchVo vo) {
        return apiResponseSuccess(userService.getPagedList(query, vo));
    }

	@Log("用户表数据列表")
    @ApiOperation(value = "用户表数据列表")
    @GetMapping(value = "/list")
    public ApiResponseInfo<List<UserEntity>> getEntityList(SearchVo vo) {
        return apiResponseSuccess(userService.getEntityList(vo));
    }
    
    @Log("根据id获取用户表Entity")
    @ApiOperation(value = "根据id获取用户表Entity")
    @GetMapping(value = "/{id}")
    public ApiResponseInfo<UserEntity> getEntityById(@NotBlank(message = "{required}") @PathVariable String id) {
    	return apiResponseSuccess(userService.getEntityById(id));
    }
    
	@Log("新增 用户表")
    @ApiOperation(value = "新增 用户表")
    @PostMapping(value = "/add")
    public ApiResponseInfo<HashMap<String, Object>> add(@RequestBody UserEntity entity) throws BearException {
	    userService.insertEntity(entity);
    	return apiResponseSuccess();
    }

	@Log("删除 用户表")
    @ApiOperation(value = "删除 用户表")
	@PostMapping(value = "/{ids}")
    public ApiResponseInfo<HashMap<String, Object>> delete(@NotBlank(message = "{required}") @PathVariable String ids) throws BearException {
    	userService.deleteEntityBatchIds(ids);
        return apiResponseSuccess();
    }

	@Log("修改 用户表")
    @ApiOperation(value = "修改 用户表")
    @PostMapping(value = "/update")
    public ApiResponseInfo<HashMap<String, Object>> update(@RequestBody UserEntity entity) throws BearException {
        userService.updateEntityById(entity);
        return apiResponseSuccess();
    }
    
	@Log("编辑 用户表")
    @ApiOperation(value = "编辑 用户表")
    @PostMapping(value = "/edit")
    public ApiResponseInfo<HashMap<String, Object>> edit(@RequestBody UserEntity entity) throws BearException {
        userService.updateEntityByWapper(entity);
        return apiResponseSuccess();
    }
}
