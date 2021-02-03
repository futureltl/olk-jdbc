package com.asiainfo.dacp.jdbc.extend;

import okhttp3.MediaType;

public final class DacpConsts {

    public static final String LOGIN_URI = "/sql/login";
    public static final String EXECUTE_URI = "/sql/execute";
    public static final String QUERY_URI = "/sql/getResult";
    public static final String PRESTO_QUERY_URI = "/v1/statement";
    
    public static final int DEFAULT_PAGE_NUM = 1;
    public static final int DEFAULT_PAGE_SIZE = 1000;
    
    public static final int DEFAULT_TOKEN_EXPIRES = 3600; // 60 * 60(s)
    
    public static final int DEFAULT_TASK_TIMEOUT = 30; // (s)
    public static final int DEFAULT_REQUEST_INTERVAL = 1; // (s)
    
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
}
