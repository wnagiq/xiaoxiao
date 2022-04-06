package ${package.ServiceImpl};

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${superServiceImplClassPackage};
import com.lollipop.candy.common.domain.QueryRequest;
import com.lollipop.candy.common.exception.BearException;
import ${package.Mapper}.${table.mapperName};
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import com.lollipop.candy.common.vo.SearchVo;

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
	public IPage<${entity}> getPagedList(QueryRequest query, SearchVo vo) {
		Page<${entity}> page = new Page<>(query.getPageNum(), query.getPageSize());
		LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper<>();
	    if(StringUtils.isNotEmpty(vo.getSearchValue())) {
//			queryWrapper.like(XtcsXsbjgxbModel::getTableCloum, vo.getSearchValue());
		}
		return baseMapper.selectPage(page, queryWrapper);
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
	public List<${entity}> getEntityList(SearchVo vo) {
		LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper<>();
		if(StringUtils.isNotEmpty(vo.getSearchValue())) {
//			queryWrapper.like(XtcsXsbjgxbModel::getTableCloum, vo.getSearchValue());
		}
		return baseMapper.selectList(queryWrapper);
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
	public ${entity} getEntityById(String id) {
		return baseMapper.selectById(id);
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
	public HashMap<String, Object> insertEntity(${entity} entity) throws BearException {
		HashMap<String, Object> ret = new HashMap<>(4);
		try {
			baseMapper.insert(entity);
			ret.put("status", Boolean.TRUE);
			ret.put("message", Globals.RESULT_INSERT_SUCCESS);
        } catch (Exception e) {
			e.printStackTrace();
			ret.put("status", Boolean.FALSE);
			ret.put("message", e.getMessage());
        }
		return ret;
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
	public HashMap<String, Object> deleteEntityBatchIds(String ids) throws BearException {
			baseMapper.deleteBatchIds(Arrays.asList(ids));
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
	public HashMap<String, Object> updateEntityById(${entity} entity) throws BearException {
			baseMapper.updateById(entity);
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
	public HashMap<String, Object> updateEntityByWapper(${entity} entity) throws BearException {
		LambdaQueryWrapper<${entity}> updateWrapper = new LambdaQueryWrapper<>();
		//updateWrapper.eq(XtcsXsbjgxbModel::getXxdm, entity.getXxdm());
		baseMapper.update(entity, updateWrapper);
	}
	
}
</#if>
