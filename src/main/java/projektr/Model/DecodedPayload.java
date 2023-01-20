
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
    "Humidity",
    "Illuminance",
    "Pressure",
    "Temperature",
    "UVA",
    "UVB",
    "UVIndex"
})
@Generated("jsonschema2pojo")
public class DecodedPayload {

    @JsonProperty("Humidity")
    private Double humidity;
    @JsonProperty("Illuminance")
    private Double illuminance;
    @JsonProperty("Pressure")
    private Double pressure;
    @JsonProperty("Temperature")
    private Double temperature;
    @JsonProperty("UVA")
    private Double uva;
    @JsonProperty("UVB")
    private Double uvb;
    @JsonProperty("UVIndex")
    private Double uVIndex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Humidity")
    public Double getHumidity() {
        return humidity;
    }

    @JsonProperty("Humidity")
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("Illuminance")
    public Double getIlluminance() {
        return illuminance;
    }

    @JsonProperty("Illuminance")
    public void setIlluminance(Double illuminance) {
        this.illuminance = illuminance;
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

    @JsonProperty("UVA")
    public Double getUva() {
        return uva;
    }

    @JsonProperty("UVA")
    public void setUva(Double uva) {
        this.uva = uva;
    }

    @JsonProperty("UVB")
    public Double getUvb() {
        return uvb;
    }

    @JsonProperty("UVB")
    public void setUvb(Double uvb) {
        this.uvb = uvb;
    }

    @JsonProperty("UVIndex")
    public Double getUVIndex() {
        return uVIndex;
    }

    @JsonProperty("UVIndex")
    public void setUVIndex(Double uVIndex) {
        this.uVIndex = uVIndex;
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
