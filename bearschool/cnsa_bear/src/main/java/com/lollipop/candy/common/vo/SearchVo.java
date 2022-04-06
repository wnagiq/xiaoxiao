package com.lollipop.candy.common.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页Model
 * @author tianyin
 *
 */
@Data
@ApiModel
public class SearchVo implements Serializable {

	private static final long serialVersionUID = 8272564134287731353L;

    @ApiModelProperty(value = "查询字段")
    private String searchValue;
    @ApiModelProperty(value = "ID")
    private Long id;
   
}