package com.lollipop.candy.test.vo;

import com.lollipop.candy.common.domain.QueryRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestVo extends QueryRequest {

	private static final long serialVersionUID = 4806709851184536627L;
	
	private String searchVaule;
}
