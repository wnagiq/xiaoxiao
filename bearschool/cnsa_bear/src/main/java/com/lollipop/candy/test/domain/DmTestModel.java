package com.lollipop.candy.test.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class DmTestModel implements Serializable {

	private static final long serialVersionUID = 3189412588584875327L;

	private String dm;
	private int px;
	private String salt;
}
