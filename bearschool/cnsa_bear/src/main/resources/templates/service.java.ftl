package ${package.Service};

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import ${superServiceClassPackage};
import com.lollipop.candy.common.exception.BearException;
import com.lollipop.candy.common.domain.QueryRequest;
import ${package.Entity}.${entity};
import com.lollipop.candy.common.vo.SearchVo;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

	/**
	 * <p>
	 *  根据搜索条件查询分页数据列表
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	IPage<${entity}> getPagedList(QueryRequest query, SearchVo vo);

	/**
	 * <p>
	 *  根据搜索条件查询数据列表
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	List<${entity}> getEntityList(SearchVo vo);

	/**
	 * <p>
	 *  根据ID查询Entity
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	${table.entityName} getEntityById(String id);

	/**
	 * <p>
	 *  保存新增数据
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	HashMap<String, Object> insertEntity(${entity} entity) throws BearException;

	/**
	 * <p>
	 * 根据ID删除数据，多个ID批量删除用","拼接
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	HashMap<String, Object> deleteEntityBatchIds(String ids) throws BearException;

	/**
	 * <p>
	 *  根据ID修改数据
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	HashMap<String, Object> updateEntityById(${entity} entity) throws BearException;

	/**
	 * <p>
	 *  根据条件修改数据
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	HashMap<String, Object> updateEntityByWapper(${entity} entity) throws BearException;
}
</#if>
