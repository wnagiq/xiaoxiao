package com.lollipop.candy.system.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lollipop.candy.common.exception.BearException;
import com.lollipop.candy.common.domain.QueryRequest;
import com.lollipop.candy.system.domain.UserEntity;
import com.lollipop.candy.common.vo.SearchVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author bear
 * @since 2022-02-23
 */
public interface UserService extends IService<UserEntity> {

	/**
	 * <p>
	 *  根据搜索条件查询分页数据列表
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	IPage<UserEntity> getPagedList(QueryRequest query, SearchVo vo);

	/**
	 * <p>
	 *  根据搜索条件查询数据列表
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	List<UserEntity> getEntityList(SearchVo vo);

	/**
	 * <p>
	 *  根据ID查询Entity
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	UserEntity getEntityById(String id);

	/**
	 * <p>
	 *  保存新增数据
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	void insertEntity(UserEntity entity)  throws BearException;

	/**
	 * <p>
	 * 根据ID删除数据，多个ID批量删除用","拼接
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	void deleteEntityBatchIds(String ids)  throws BearException;

	/**
	 * <p>
	 *  根据ID修改数据
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	void updateEntityById(UserEntity entity)  throws BearException;

	/**
	 * <p>
	 *  根据条件修改数据
	 * </p>
	 *
	 * @author bear
	 * @since 2022-02-23
	 */
	void updateEntityByWapper(UserEntity entity)  throws BearException;
}
