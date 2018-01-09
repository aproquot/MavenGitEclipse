
package com.MavenGitEclipse.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dataset",
    "timezone",
    "rows",
    "format"
})
public class Parameters {

    @JsonProperty("dataset")
    private List<String> dataset = null;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("rows")
    private Integer rows;
    @JsonProperty("format")
    private String format;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dataset")
    public List<String> getDataset() {
        return dataset;
    }

    @JsonProperty("dataset")
    public void setDataset(List<String> dataset) {
        this.dataset = dataset;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("rows")
    public Integer getRows() {
        return rows;
    }

    @JsonProperty("rows")
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
