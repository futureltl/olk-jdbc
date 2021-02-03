package com.asiainfo.dacp.jdbc.extend;

public enum ResultTypeEnum {
    RESULT("result"),
    CURSOR("cursor"),
    OLK("olk");
    
    private String type;
    private ResultTypeEnum(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
