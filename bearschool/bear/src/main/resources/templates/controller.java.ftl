package ${package.Controller};

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lollipop.star.common.controller.ApiResponseInfo;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import com.lollipop.star.common.exception.FebsException;
import com.lollipop.star.common.model.QueryRequest;
import com.lollipop.star.common.model.ResultModel;
import ${package.Entity}.${table.entityName};
import ${package.Service}.${table.serviceName};
import com.lollipop.star.exam.vo.SearchVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


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
@Validated
@Api(value = ${table.comment!}, description = ${table.comment!}, tags = ${table.comment!})
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

    @ApiOperation(value = "${table.comment}分页列表")
    @GetMapping(value = "/page")
    public ApiResponseInfo<IPage<${table.entityName}>> getPagedList(QueryRequest query, SearchVo vo) throws FebsException {
        return apiResponseSuccess(${table.serviceName?uncap_first}.getPagedList(query, vo));
    }

    @ApiOperation(value = "${table.comment}数据列表")
    @GetMapping(value = "/list")
    public ApiResponseInfo<List<${table.entityName}>> getEntityList(SearchVo vo) throws FebsException {
        return apiResponseSuccess(${table.serviceName?uncap_first}.getEntityList(vo));
    }

    @ApiOperation(value = "新增")
    @PostMapping(value = "/add")
    public ApiResponseInfo<ResultModel> add(@RequestBody ${table.entityName} entity) throws FebsException {
    	return apiResponseFailed(${table.serviceName?uncap_first}.insertEntity(entity));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping(value = "/{ids}")
    public ApiResponseInfo<ResultModel> delete(@NotBlank(message = "{required}") @PathVariable String ids) throws FebsException {
        return apiResponseSuccess(${table.serviceName?uncap_first}.deleteEntityBatchIds(ids));
    }

    @ApiOperation(value = "修改")
    @PutMapping(value = "/update")
    public ApiResponseInfo<ResultModel> update(@Valid ${table.entityName} entity) throws FebsException {
        return apiResponseSuccess(${table.serviceName?uncap_first}.updateEntityById(entity));
    }
    
    @ApiOperation(value = "编辑")
    @PutMapping(value = "/edit")
    public ApiResponseInfo<ResultModel> edit(@Valid ${table.entityName} entity) throws FebsException {
        return apiResponseSuccess(${table.serviceName?uncap_first}.updateEntityByWapper(entity));
    }

}
</#if>