package com.lollipop.star.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ResultInsertModel {
	
    @ApiModelProperty(value = "返回状态")
    private boolean res;
    @ApiModelProperty(value = "返回消息")
    private String message;
}