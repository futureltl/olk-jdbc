package com.asiainfo.dacp.client;

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Immutable
public final class QueryParams {

    private final String taskId;
    private final String type;
    private final String accessToken;
    private final int pageNum;
    private final int pageSize;

    @JsonCreator
    public QueryParams(@JsonProperty("taskId") String taskId, @JsonProperty("type") String type,
            @JsonProperty("accessToken") String accessToken, @JsonProperty("pageNum") int pageNum,
            @JsonProperty("pageSize") int pageSize) {
        this.taskId = requireNonNull(taskId, "taskId is null.");
        this.type = requireNonNull(type, "type is null.");
        this.accessToken = requireNonNull(accessToken, "accessToken is null.");
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    @Nonnull
    @JsonProperty
    public String getTaskId() {
        return taskId;
    }

    @Nonnull
    @JsonProperty
    public String getType() {
        return type;
    }

    @Nonnull
    @JsonProperty
    public String getAccessToken() {
        return accessToken;
    }

    @Nullable
    @JsonProperty
    public int getPageNum() {
        return pageNum;
    }

    @Nullable
    @JsonProperty
    public int getPageSize() {
        return pageSize;
    }
}
