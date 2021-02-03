package com.asiainfo.dacp.jdbc.extend;

import static io.prestosql.client.FixJsonDataUtils.fixData;
import static java.util.Objects.requireNonNull;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.prestosql.client.Column;

@Immutable
public final class CursorResults {

    private final Iterable<List<Object>> data;
    private final List<Column> schema;
    private final int pageNum;
    private final int pageSize;
    private final int total;

    @JsonCreator
    public CursorResults(@JsonProperty("data") List<List<Object>> data, @JsonProperty("schema") List<Column> schema,
            @JsonProperty("pageNum") int pageNum, @JsonProperty("pageSize") int pageSize,
            @JsonProperty("total") int total) {
        this(fixData(schema.size(), data), schema, pageNum, pageSize, total);
    }

    public CursorResults(Iterable<List<Object>> data, List<Column> schema, int pageNum, int pageSize, int total) {
        this.data = data;
        this.schema = schema;
        this.pageNum = requireNonNull(pageNum, "pageNum is null.");
        this.pageSize = requireNonNull(pageSize, "pageSize is null.");
        this.total = requireNonNull(total, "total is null.");
    }

    @Nullable
    @JsonProperty
    public Iterable<List<Object>> getData() {
        return data;
    }

    @Nullable
    @JsonProperty
    public List<Column> getSchema() {
        return schema;
    }

    @Nonnull
    @JsonProperty
    public int getPageNum() {
        return pageNum;
    }

    @Nonnull
    @JsonProperty
    public int getPageSize() {
        return pageSize;
    }

    @Nonnull
    @JsonProperty
    public int getTotal() {
        return total;
    }
}
