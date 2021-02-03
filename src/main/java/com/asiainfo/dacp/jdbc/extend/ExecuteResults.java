package com.asiainfo.dacp.jdbc.extend;

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Immutable
public final class ExecuteResults {

    private final String taskId;
    private final String type;
    private final boolean success;
    private final String code;
    private final String message;
    private final String errDetail;
//    private final List<ExecutePlan> executePlan;
    private final String olkSQL;
    

    @JsonCreator
    public ExecuteResults(@JsonProperty("taskId") String taskId, 
            @JsonProperty("type") String type, 
            @JsonProperty("success") boolean success,
            @JsonProperty("code") String code, 
            @JsonProperty("message") String message,
            @JsonProperty("errDetail") String errDetail,
            @JsonProperty("olkSQL") String olkSQL) {
//            @JsonProperty("executePlan") List<ExecutePlan> executePlan) {
        this.taskId = requireNonNull(taskId, "taskId is null");
        this.type = requireNonNull(type, "type is null");
        this.success = requireNonNull(success, "success is null");
        this.code = requireNonNull(code, "code is null");
        this.message = message;
        this.errDetail = errDetail;
//        this.executePlan = executePlan;
        this.olkSQL = olkSQL;
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
    public boolean isSuccess() {
        return success;
    }

    @Nonnull
    @JsonProperty
    public String getCode() {
        return code;
    }

    @Nullable
    @JsonProperty
    public String getMessage() {
        return message;
    }

    @Nullable
    @JsonProperty
    public String getErrDetail() {
        return errDetail;
    }

    @Nullable
    @JsonProperty
    public String getOlkSQL() {
        return olkSQL;
    }

//    @Nullable
//    @JsonProperty
//    public List<ExecutePlan> getExecutePlan() {
//        return executePlan;
//    }
}
