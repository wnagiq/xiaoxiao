package ${package.ServiceImpl};

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${superServiceImplClassPackage};
import com.lollipop.star.common.constants.ResultConstants;
import com.lollipop.star.common.exception.FebsException;
import com.lollipop.star.common.model.QueryRequest;
import com.lollipop.star.common.model.ResultModel;
import com.lollipop.star.common.utils.ResultUtil;
import ${package.Mapper}.${table.mapperName};
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import com.lollipop.star.exam.vo.SearchVo;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
	
	/**
	 * <p>
	 *  根据搜索条件查询分页数据列表
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	@Override
	public IPage<${entity}> getPagedList(QueryRequest query, SearchVo vo) throws FebsException {
		try{
			Page<${entity}> page = new Page<>(query.getPageNum(), query.getPageSize());
			QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
			if(StringUtils.isNotEmpty(vo.getSearchValue())) {
//				queryWrapper.like("", vo.getSearchValue());
			}
			return baseMapper.selectPage(page, queryWrapper);
		}catch(Exception e){
			e.printStackTrace();
			throw new FebsException(ResultConstants.RESULT_SELECT_FAIL);
		}
	}

	/**
	 * <p>
	 *  根据搜索条件查询数据列表
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	@Override
	public List<${entity}> getEntityList(SearchVo vo) throws FebsException {
		try{
			QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
			if(StringUtils.isNotEmpty(vo.getSearchValue())) {
//				queryWrapper.like("", vo.getSearchValue());
			}
			return baseMapper.selectList(queryWrapper);
		}catch(Exception e){
			e.printStackTrace();
			throw new FebsException(ResultConstants.RESULT_SELECT_FAIL);
		}
	}

	/**
	 * <p>
	 *  根据ID查询Entity
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	@Override
	public ${entity} getEntityById(String id) throws FebsException {
		try{
			return baseMapper.selectById(id);
		}catch(Exception e){
			e.printStackTrace();
			throw new FebsException(ResultConstants.RESULT_SELECT_FAIL);
		}
	}

	/**
	 * <p>
	 *  保存新增数据
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	@Override
	public ResultModel insertEntity(${entity} entity) throws FebsException {
		try{
			return ResultUtil.resultInsert(baseMapper.insert(entity));
		}catch(Exception e){
			e.printStackTrace();
			throw new FebsException(ResultConstants.RESULT_INSERT_FAIL);
		}
	}

	/**
	 * <p>
	 * 根据ID删除数据，多个ID批量删除用","拼接
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	@Override
	public ResultModel deleteEntityBatchIds(String ids) throws FebsException {
		try{
			return ResultUtil.resultDelete(baseMapper.deleteBatchIds(Arrays.asList(ids)));
		}catch(Exception e){
			e.printStackTrace();
			throw new FebsException(ResultConstants.RESULT_DELETE_FAIL);
		}
	}

	/**
	 * <p>
	 *  根据ID修改数据
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	@Override
	public ResultModel updateEntityById(${entity} entity) throws FebsException {
		try{
			return ResultUtil.resultUpdate(baseMapper.updateById(entity));
		}catch(Exception e){
			e.printStackTrace();
			throw new FebsException(ResultConstants.RESULT_UPDATE_FAIL);
		}
	}

	/**
	 * <p>
	 *  根据条件修改数据
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	@Override
	public ResultModel updateEntityByWapper(${entity} entity) throws FebsException {
		try{
			UpdateWrapper<${entity}> updateWrapper = new UpdateWrapper<>();
			Map<String, Object> params = new HashMap<>();
			params.put("id", entity.getId());
			updateWrapper.allEq(params);
			return ResultUtil.resultUpdate(baseMapper.update(entity, updateWrapper));
		}catch(Exception e){
			e.printStackTrace();
			throw new FebsException(ResultConstants.RESULT_UPDATE_FAIL);
		}
	}
	
}
</#if>
