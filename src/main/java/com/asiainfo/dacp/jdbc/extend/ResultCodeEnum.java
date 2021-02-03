package com.asiainfo.dacp.jdbc.extend;

public enum ResultCodeEnum {
    SUCCESS("000", "Executed successfull!"),
    RUNNING("001", "Running!"),
    INPUT_PARAMS_ERROR("100", "input parameters error."),
    SQL_SYNTAX_ERROR("200", "sql syntax error."),
    SQL_EXECUTE_ERROR("300", "error while executing sql."),
    SQL_PERMIT_ERROR("400", "sql not have execute permission."),
    NULL_PARAMS_ERROR("500", "parameter is null."),
    LOGIN_ERROR("600", "login failure."),
    TOKEN_EXPIRED_ERROR("700", "Token expired error."),
    UNKNOWN_ERROR("999", "unknown error.");
    
    private String code;
    private String message;
    
    private ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public static String getMessage(String code) {
        for (ResultCodeEnum result : ResultCodeEnum.values()) {
            if(result.getCode().equals(code)) {
                return result.getMessage();
            }
        }
        
        return null;
    }
}
