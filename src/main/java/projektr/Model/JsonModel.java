
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
    "end_device_ids",
    "received_at",
    "uplink_message"
})
@Generated("jsonschema2pojo")
public class JsonModel {

    @JsonProperty("end_device_ids")
    private EndDeviceIds endDeviceIds;
    @JsonProperty("received_at")
    private String receivedAt;
    @JsonProperty("uplink_message")
    private UplinkMessage uplinkMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("end_device_ids")
    public EndDeviceIds getEndDeviceIds() {
        return endDeviceIds;
    }

    @JsonProperty("end_device_ids")
    public void setEndDeviceIds(EndDeviceIds endDeviceIds) {
        this.endDeviceIds = endDeviceIds;
    }

    @JsonProperty("received_at")
    public String getReceivedAt() {
        return receivedAt;
    }

    @JsonProperty("received_at")
    public void setReceivedAt(String receivedAt) {
        this.receivedAt = receivedAt;
    }

    @JsonProperty("uplink_message")
    public UplinkMessage getUplinkMessage() {
        return uplinkMessage;
    }

    @JsonProperty("uplink_message")
    public void setUplinkMessage(UplinkMessage uplinkMessage) {
        this.uplinkMessage = uplinkMessage;
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
