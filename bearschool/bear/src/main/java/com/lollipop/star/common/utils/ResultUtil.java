package com.lollipop.star.common.utils;

import com.lollipop.star.common.constants.ResultConstants;
import com.lollipop.star.common.model.ResultModel;

public class ResultUtil {

	public static ResultModel resultInsert(int a) {
		ResultModel res = new ResultModel();
		res.setRes(a > 0 ? true : false);
		res.setMessage(a > 0 ? ResultConstants.RESULT_INSERT_SUCCESS : ResultConstants.RESULT_INSERT_FAIL);
		return res;
	}

	public static ResultModel resultInsert(Boolean a) {
		ResultModel res = new ResultModel();
		res.setRes(a);
		res.setMessage(a ? ResultConstants.RESULT_INSERT_SUCCESS : ResultConstants.RESULT_INSERT_FAIL);
		return res;
	}

	public static ResultModel resultUpdate(int a) {
		ResultModel res = new ResultModel();
		res.setRes(a > 0 ? true : false);
		res.setMessage(a > 0 ? ResultConstants.RESULT_UPDATE_SUCCESS : ResultConstants.RESULT_UPDATE_FAIL);
		return res;
	}

	public static ResultModel resultUpdate(Boolean a) {
		ResultModel res = new ResultModel();
		res.setRes(a);
		res.setMessage(a ? ResultConstants.RESULT_UPDATE_SUCCESS : ResultConstants.RESULT_UPDATE_FAIL);
		return res;
	}

	public static ResultModel resultDelete(int a) {
		ResultModel res = new ResultModel();
		res.setRes(a > 0 ? true : false);
		res.setMessage(a > 0 ? ResultConstants.RESULT_DELETE_SUCCESS : ResultConstants.RESULT_DELETE_FAIL);
		return res;
	}

	public static ResultModel resultDelete(Boolean a) {
		ResultModel res = new ResultModel();
		res.setRes(a);
		res.setMessage(a ? ResultConstants.RESULT_DELETE_SUCCESS : ResultConstants.RESULT_DELETE_FAIL);
		return res;
	}

}