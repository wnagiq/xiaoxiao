package ${package.Mapper};

import ${package.Entity}.${entity};
import com.lollipop.star.exam.vo.SearchVo;
import com.baomidou.dynamic.datasource.annotation.DS;
import ${superMapperClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
@DS(value="primary")
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

	IPage<${entity}> selectPagedList(Page<${entity}> page, SearchVo vo);

}
</#if>
