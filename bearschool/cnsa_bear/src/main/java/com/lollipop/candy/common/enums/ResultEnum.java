package com.lollipop.candy.common.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import com.lollipop.candy.common.constants.ResultConstants;
/**
 * @创建人 bear
 * @创建时间 2020/4/2 10:45
 * @描述 
 * @修改人和其它信息
 */
public enum ResultEnum {

    SUEECESS_INSERT(ResultConstants.INSERT, Boolean.TRUE, ResultConstants.RESULT_INSERT_SUCCESS),
    FAIL_INSERT(ResultConstants.INSERT, Boolean.FALSE, ResultConstants.RESULT_INSERT_FAIL),
    SUEECESS_DELETE(ResultConstants.DELETE, Boolean.TRUE, ResultConstants.RESULT_DELETE_SUCCESS),
    FAIL_DELETE(ResultConstants.DELETE, Boolean.FALSE, ResultConstants.RESULT_DELETE_FAIL),
    SUEECESS_UPDATE(ResultConstants.UPDATE, Boolean.TRUE, ResultConstants.RESULT_UPDATE_SUCCESS),
    FAIL_UPDATE(ResultConstants.UPDATE, Boolean.FALSE, ResultConstants.RESULT_UPDATE_FAIL),
    SUEECESS_SELECT(ResultConstants.SELECT, Boolean.TRUE, ResultConstants.RESULT_SELECT_SUCCESS),
    FAIL_SELECT(ResultConstants.SELECT, Boolean.FALSE, ResultConstants.RESULT_SELECT_FAIL);

    private String name;
    private Boolean state;
    private String value;

    public String getName() {
        return name;
    }
    
    public Boolean getState() {
    	return state;
    }

    public String getValue() {
        return value;
    }

    ResultEnum(String name, Boolean state, String value) {
        this.name = name;
        this.state = state;
        this.value = value;
    }

    public static String getValueByName(String name, Boolean state) {
        Map<Boolean, String> map = Arrays.stream(ResultEnum.values()).filter(ResultEnum -> ResultEnum.getName().equals(name)).collect(Collectors.toMap(ResultEnum::getState, ResultEnum::getValue));
        return map.get(state);
    }
}
