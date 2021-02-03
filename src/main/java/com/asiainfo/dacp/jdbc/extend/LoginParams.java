package com.asiainfo.dacp.jdbc.extend;

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Immutable
public final class LoginParams {
    private final String user;
    private final String pwd;
    private final String database;
    private final int expires;

    @JsonCreator
    public LoginParams(@JsonProperty("user") String user, @JsonProperty("pwd") String pwd,
            @JsonProperty("database") String database, @JsonProperty("expires") int expires) {
        this.user = requireNonNull(user, "user is null.");
        this.pwd = requireNonNull(pwd, "pwd is null.");
        this.expires = requireNonNull(expires, "expires is null.");
        this.database = database;
    }

    @Nonnull
    @JsonProperty
    public String getUser() {
        return user;
    }

    @Nonnull
    @JsonProperty
    public String getPwd() {
        return pwd;
    }
    
    @Nonnull
    @JsonProperty
    public int getExpires() {
        return expires;
    }

    @Nullable
    @JsonProperty
    public String getDatabase() {
        return database;
    }
}
