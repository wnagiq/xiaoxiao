package com.lollipop.star.exam.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 图表分页查询参数传输对象
 * @author: wq
 * @date: 2020/3/19 16:34
 */
@ApiModel(value = "SearchVo", description = "传输对象")
@Data
public class SearchVo implements Serializable {
	
	private static final long serialVersionUID = -1467091247047959786L;
	
	private String searchValue;    

}