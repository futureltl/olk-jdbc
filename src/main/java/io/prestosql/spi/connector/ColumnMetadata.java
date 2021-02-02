/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.prestosql.spi.connector;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.prestosql.spi.type.Type;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static io.prestosql.spi.connector.SchemaUtil.checkNotEmpty;
import static java.util.Collections.emptyMap;
import static java.util.Collections.unmodifiableMap;
import static java.util.Locale.ENGLISH;
import static java.util.Objects.requireNonNull;

public class ColumnMetadata
{
    private final String name;
    private final Type type;
    private final boolean nullable;
    private final String comment;
    private final String extraInfo;
    private final boolean hidden;
    private final Map<String, Object> properties;

    public ColumnMetadata(String name, Type type)
    {
        this(name, type, true, null, null, false, emptyMap());
    }

    public ColumnMetadata(String name, Type type, String comment, boolean hidden)
    {
        this(name, type, true, comment, null, hidden, emptyMap());
    }

    public ColumnMetadata(String name, Type type, String comment, String extraInfo, boolean hidden)
    {
        this(name, type, true, comment, extraInfo, hidden, emptyMap());
    }

    public ColumnMetadata(String name, Type type, String comment, String extraInfo, boolean hidden, Map<String, Object> properties)
    {
        this(name, type, true, comment, extraInfo, hidden, properties);
    }

    @JsonCreator
    public ColumnMetadata(
            @JsonProperty("name") String name,
            @JsonProperty("type") Type type,
            @JsonProperty("nullable") boolean nullable,
            @JsonProperty("comment") String comment,
            @JsonProperty("extraInfo") String extraInfo,
            @JsonProperty("hidden") boolean hidden,
            @JsonProperty("properties") Map<String, Object> properties)
    {
        checkNotEmpty(name, "name");
        requireNonNull(type, "type is null");
        requireNonNull(properties, "properties is null");

        this.name = name.toLowerCase(ENGLISH);
        this.type = type;
        this.comment = comment;
        this.extraInfo = extraInfo;
        this.hidden = hidden;
        this.properties = properties.isEmpty() ? emptyMap() : unmodifiableMap(new LinkedHashMap<>(properties));
        this.nullable = nullable;
    }

    @JsonProperty
    public String getName()
    {
        return name;
    }

    @JsonProperty
    public Type getType()
    {
        return type;
    }

    @JsonProperty
    public boolean isNullable()
    {
        return nullable;
    }

    @JsonProperty
    public String getComment()
    {
        return comment;
    }

    @JsonProperty
    public String getExtraInfo()
    {
        return extraInfo;
    }

    @JsonProperty
    public boolean isHidden()
    {
        return hidden;
    }

    @JsonProperty
    public Map<String, Object> getProperties()
    {
        return properties;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("ColumnMetadata{");
        sb.append("name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append(", ").append(nullable ? "nullable" : "nonnull");
        if (comment != null) {
            sb.append(", comment='").append(comment).append('\'');
        }
        if (extraInfo != null) {
            sb.append(", extraInfo='").append(extraInfo).append('\'');
        }
        if (hidden) {
            sb.append(", hidden");
        }
        if (!properties.isEmpty()) {
            sb.append(", properties=").append(properties);
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, type, nullable, comment, extraInfo, hidden);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColumnMetadata other = (ColumnMetadata) obj;
        return Objects.equals(this.name, other.name) &&
                Objects.equals(this.type, other.type) &&
                Objects.equals(this.nullable, other.nullable) &&
                Objects.equals(this.comment, other.comment) &&
                Objects.equals(this.extraInfo, other.extraInfo) &&
                Objects.equals(this.hidden, other.hidden);
    }
}
