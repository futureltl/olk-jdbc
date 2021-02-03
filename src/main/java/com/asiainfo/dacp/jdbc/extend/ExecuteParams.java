package com.asiainfo.dacp.jdbc.extend;

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Immutable
public final class ExecuteParams {

    private final String sql;
    private final String accessToken;

    @JsonCreator
    public ExecuteParams(@JsonProperty("sql") String sql, @JsonProperty("accessToken") String accessToken) {
        this.sql = requireNonNull(sql, "sql is null");
        this.accessToken = requireNonNull(accessToken, "accessToken is null");
    }

    @Nonnull
    @JsonProperty
    public String getSql() {
        return sql;
    }

    @Nonnull
    @JsonProperty
    public String getAccessToken() {
        return accessToken;
    }
}
