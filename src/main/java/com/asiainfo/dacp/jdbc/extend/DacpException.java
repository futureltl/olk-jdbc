package com.asiainfo.dacp.jdbc.extend;

public class DacpException extends Exception {

    public DacpException() {
        super(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
    }
    
    public DacpException(String message) {
        super(message);
    }
    
    public DacpException(String message, Throwable cause) {
        super(message, cause);
    }
}
