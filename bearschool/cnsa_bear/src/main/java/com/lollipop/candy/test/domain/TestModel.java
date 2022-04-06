package com.lollipop.candy.test.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class TestModel implements Serializable {

	private static final long serialVersionUID = -8763541200997644121L;

	private String id;
	
	private String username;
	
	private String name;
}
