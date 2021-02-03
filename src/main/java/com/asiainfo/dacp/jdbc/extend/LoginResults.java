package com.asiainfo.dacp.jdbc.extend;

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Immutable
public final class LoginResults {
    private final String accessToken;
    private final int expires;
    private final String user;
    private final String code;
    private final String msg;
    private final String olkURL;

    @JsonCreator
    public LoginResults(@JsonProperty("accessToken") String accessToken,
            @JsonProperty("expires") int expires, 
            @JsonProperty("user") String user,
            @JsonProperty("code") String code,
            @JsonProperty("msg") String msg,
            @JsonProperty("olkURL") String olkURL) {
        this.accessToken = requireNonNull(accessToken, "accessToken is null");
        this.expires = requireNonNull(expires, "expires is null");
        this.user = requireNonNull(user, "user is null");
        this.code = requireNonNull(code, "code is null");
        this.msg = msg;
        this.olkURL = olkURL;
    }

    @Nonnull
    @JsonProperty
    public int getExpires() {
        return expires;
    }

    @Nonnull
    @JsonProperty
    public String getAccessToken() {
        return accessToken;
    }

    @Nonnull
    @JsonProperty
    public String getUser() {
        return user;
    }

    @Nonnull
    @JsonProperty
    public String getCode() {
        return code;
    }

    @Nullable
    @JsonProperty
    public String getMsg() {
        return msg;
    }

    @Nullable
    @JsonProperty
    public String getOlkURL() {
        return olkURL;
    }
}
