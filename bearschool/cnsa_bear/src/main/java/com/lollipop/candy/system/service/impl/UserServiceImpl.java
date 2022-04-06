package com.lollipop.candy.system.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lollipop.candy.common.domain.QueryRequest;
import com.lollipop.candy.common.exception.BearException;
import com.lollipop.candy.common.vo.SearchVo;
import com.lollipop.candy.system.dao.UserMapper;
import com.lollipop.candy.system.domain.UserEntity;
import com.lollipop.candy.system.service.UserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author bear
 * @since 2022-02-23
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

	/**
	 * <p>
	 *  根据搜索条件查询分页数据列表
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	public IPage<UserEntity> getPagedList(QueryRequest query, SearchVo vo) {
			Page<UserEntity> page = new Page<>(query.getPageNum(), query.getPageSize());
			LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
		    if(StringUtils.isNotEmpty(vo.getSearchValue())) {
//				queryWrapper.like(XtcsXsbjgxbModel::getTableCloum, vo.getSearchValue());
			}
			return baseMapper.selectPage(page, queryWrapper);
	}

	/**
	 * <p>
	 *  根据搜索条件查询数据列表
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	@Override
	public List<UserEntity> getEntityList(SearchVo vo) {
			LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
			if(StringUtils.isNotEmpty(vo.getSearchValue())) {
//				queryWrapper.like(XtcsXsbjgxbModel::getTableCloum, vo.getSearchValue());
			}
			return baseMapper.selectList(queryWrapper);
	}

	/**
	 * <p>
	 *  根据ID查询Entity
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	@Override
	public UserEntity getEntityById(String id) {
			return baseMapper.selectById(id);
	}

	/**
	 * <p>
	 *  保存新增数据
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	@Override
	public void insertEntity(UserEntity entity) throws BearException {
			baseMapper.insert(entity);
	}

	/**
	 * <p>
	 * 根据ID删除数据，多个ID批量删除用","拼接
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	@Override
	public  void deleteEntityBatchIds(String ids) throws BearException {
			baseMapper.deleteBatchIds(Arrays.asList(ids));
	}

	/**
	 * <p>
	 *  根据ID修改数据
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	@Override
	public void updateEntityById(UserEntity entity) throws BearException {
			baseMapper.updateById(entity);
	}

	/**
	 * <p>
	 *  根据条件修改数据
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	@Override
	public void updateEntityByWapper(UserEntity entity) throws BearException {
		LambdaQueryWrapper<UserEntity> updateWrapper = new LambdaQueryWrapper<>();
		//updateWrapper.eq(XtcsXsbjgxbModel::getXxdm, entity.getXxdm());
		baseMapper.update(entity, updateWrapper);
	}
	
}
