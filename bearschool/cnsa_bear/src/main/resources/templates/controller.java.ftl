package ${package.Controller};

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
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import com.lollipop.candy.common.domain.QueryRequest;
import com.lollipop.candy.common.exception.BearException;
import ${package.Entity}.${table.entityName};
import ${package.Service}.${table.serviceName};
import com.lollipop.candy.common.vo.SearchVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@RestController
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@Slf4j
@Api(value = "${table.comment!}", description = "${table.comment!}", tags = "${table.comment!}")
<#if kotlin>
class ${table.controllerName}
<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

	@Log("${table.comment}分页列表")
    @ApiOperation(value = "${table.comment}分页列表")
    @GetMapping(value = "/page")
    public ApiResponseInfo<IPage<${table.entityName}>> getPagedList(QueryRequest query, SearchVo vo) {
        return apiResponseSuccess(${table.serviceName?uncap_first}.getPagedList(query, vo));
    }

	@Log("${table.comment}数据列表")
    @ApiOperation(value = "${table.comment}数据列表")
    @GetMapping(value = "/list")
    public ApiResponseInfo<List<${table.entityName}>> getEntityList(SearchVo vo) {
        return apiResponseSuccess(${table.serviceName?uncap_first}.getEntityList(vo));
    }
    
    @Log("根据id获取${table.comment}Entity")
    @ApiOperation(value = "根据id获取${table.comment}Entity")
    @GetMapping(value = "/{id}")
    public ApiResponseInfo<${table.entityName}> getEntityById(@NotBlank(message = "{required}") @PathVariable String id) {
    	return apiResponseSuccess(${table.serviceName?uncap_first}.getEntityById(id));
    }
    
	@Log("新增 ${table.comment!}")
    @ApiOperation(value = "新增 ${table.comment!}")
    @PostMapping(value = "/add")
    public ApiResponseInfo<HashMap<String, Object>> add(@RequestBody ${table.entityName} entity) throws BearException {
    	return apiResponseSuccess(${table.serviceName?uncap_first}.insertEntity(entity));
    }

	@Log("删除 ${table.comment!}")
    @ApiOperation(value = "删除 ${table.comment!}")
    @PostMapping(value = "/{ids}")
    public ApiResponseInfo<HashMap<String, Object>> delete(@NotBlank(message = "{required}") @PathVariable String ids) throws BearException {
        return apiResponseSuccess(${table.serviceName?uncap_first}.deleteEntityBatchIds(ids));
    }

	@Log("修改 ${table.comment!}")
    @ApiOperation(value = "修改 ${table.comment!}")
    @PostMapping(value = "/update")
    public ApiResponseInfo<HashMap<String, Object>> update(@RequestBody ${table.entityName} entity) throws BearException {
        return apiResponseSuccess(${table.serviceName?uncap_first}.updateEntityById(entity));
    }
    
	@Log("编辑 ${table.comment!}")
    @ApiOperation(value = "编辑 ${table.comment!}")
    @PostMapping(value = "/edit")
    public ApiResponseInfo<HashMap<String, Object>> edit(@RequestBody ${table.entityName} entity) throws BearException {
        return apiResponseSuccess(${table.serviceName?uncap_first}.updateEntityByWapper(entity));
    }
}
</#if>