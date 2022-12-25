
package projektr.Model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bandwidth",
    "spreading_factor",
    "coding_rate"
})
@Generated("jsonschema2pojo")
public class Lora {

    @JsonProperty("bandwidth")
    private Integer bandwidth;
    @JsonProperty("spreading_factor")
    private Integer spreadingFactor;
    @JsonProperty("coding_rate")
    private String codingRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bandwidth")
    public Integer getBandwidth() {
        return bandwidth;
    }

    @JsonProperty("bandwidth")
    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    @JsonProperty("spreading_factor")
    public Integer getSpreadingFactor() {
        return spreadingFactor;
    }

    @JsonProperty("spreading_factor")
    public void setSpreadingFactor(Integer spreadingFactor) {
        this.spreadingFactor = spreadingFactor;
    }

    @JsonProperty("coding_rate")
    public String getCodingRate() {
        return codingRate;
    }

    @JsonProperty("coding_rate")
    public void setCodingRate(String codingRate) {
        this.codingRate = codingRate;
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
