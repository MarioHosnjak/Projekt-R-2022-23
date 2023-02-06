
package projektr.Model;

import java.util.LinkedHashMap;
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
    "Humidity",
    "Motions",
    "PM10",
    "PM25",
    "Pressure",
    "Temperature"
})
@Generated("jsonschema2pojo")
public class DecodedPayload {

    @JsonProperty("Humidity")
    private Double humidity;
    @JsonProperty("Motions")
    private Integer motions;
    @JsonProperty("PM10")
    private Integer pm10;
    @JsonProperty("PM25")
    private Integer pm25;
    @JsonProperty("Pressure")
    private Double pressure;
    @JsonProperty("Temperature")
    private Double temperature;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Humidity")
    public Double getHumidity() {
        return humidity;
    }

    @JsonProperty("Humidity")
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("Motions")
    public Integer getMotions() {
        return motions;
    }

    @JsonProperty("Motions")
    public void setMotions(Integer motions) {
        this.motions = motions;
    }

    @JsonProperty("PM10")
    public Integer getPm10() {
        return pm10;
    }

    @JsonProperty("PM10")
    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }

    @JsonProperty("PM25")
    public Integer getPm25() {
        return pm25;
    }

    @JsonProperty("PM25")
    public void setPm25(Integer pm25) {
        this.pm25 = pm25;
    }

    @JsonProperty("Pressure")
    public Double getPressure() {
        return pressure;
    }

    @JsonProperty("Pressure")
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("Temperature")
    public Double getTemperature() {
        return temperature;
    }

    @JsonProperty("Temperature")
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
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
