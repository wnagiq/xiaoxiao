package ${package.Service};

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import ${superServiceClassPackage};
import com.lollipop.star.common.exception.FebsException;
import com.lollipop.star.common.model.QueryRequest;
import com.lollipop.star.common.model.ResultModel;
import ${package.Entity}.${entity};
import com.lollipop.star.exam.vo.SearchVo;

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
	IPage<${entity}> getPagedList(QueryRequest query, SearchVo vo) throws FebsException;

	/**
	 * <p>
	 *  根据搜索条件查询数据列表
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	List<${entity}> getEntityList(SearchVo vo) throws FebsException;

	/**
	 * <p>
	 *  根据ID查询Entity
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	${entity} getEntityById(String id) throws FebsException;

	/**
	 * <p>
	 *  保存新增数据
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	ResultModel insertEntity(${entity} entity) throws FebsException;

	/**
	 * <p>
	 * 根据ID删除数据，多个ID批量删除用","拼接
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	ResultModel deleteEntityBatchIds(String ids) throws FebsException;

	/**
	 * <p>
	 *  根据ID修改数据
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	ResultModel updateEntityById(${entity} entity) throws FebsException;

	/**
	 * <p>
	 *  根据条件修改数据
	 * </p>
	 *
	 * @author ${author}
	 * @since ${date}
	 */
	ResultModel updateEntityByWapper(${entity} entity) throws FebsException;
}
</#if>
