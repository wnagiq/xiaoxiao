package com.lollipop.candy.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页Model
 * @author tianyin
 *
 */
@Data
@ApiModel
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -4869594085374385813L;
    @ApiModelProperty(value = "每页个数")
    private int pageSize = Integer.MAX_VALUE;
    @ApiModelProperty(value = "页数")
    private int pageNum = 1;
    @ApiModelProperty(value = "排序字段")
    private String sortField;
    @ApiModelProperty(value = "排序规则")
    private String sortOrder;
}
