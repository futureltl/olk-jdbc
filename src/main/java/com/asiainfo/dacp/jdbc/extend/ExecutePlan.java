package com.asiainfo.dacp.jdbc.extend;

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Immutable
public final class ExecutePlan {
    private final String stepId;
    private final String dependentStep;
    private final String comm;
    private final String para;
    private final String cluster;
    private final String comment;

    @JsonCreator
    public ExecutePlan(@JsonProperty("stepId") String stepId, @JsonProperty("dependentStep") String dependentStep,
            @JsonProperty("comm") String comm, @JsonProperty("para") String para,
            @JsonProperty("cluster") String cluster, @JsonProperty("comment") String comment) {
        this.stepId = requireNonNull(stepId, "stepId is null");
        this.dependentStep = dependentStep;
        this.comm = comm;
        this.para = requireNonNull(para, "para is null");
        this.cluster = requireNonNull(cluster, "cluster is null");
        this.comment = comment;
    }

    @Nonnull
    @JsonProperty
    public String getStepId() {
        return stepId;
    }

    @Nullable
    @JsonProperty
    public String getDependentStep() {
        return dependentStep;
    }

    @Nullable
    @JsonProperty
    public String getComm() {
        return comm;
    }

    @Nonnull
    @JsonProperty
    public String getPara() {
        return para;
    }

    @Nonnull
    @JsonProperty
    public String getCluster() {
        return cluster;
    }

    @Nullable
    @JsonProperty
    public String getComment() {
        return comment;
    }
}
