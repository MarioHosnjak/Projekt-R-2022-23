
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
    "device_id",
    "application_ids",
    "dev_eui",
    "join_eui",
    "dev_addr"
})
@Generated("jsonschema2pojo")
public class DeviceIds {

    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("application_ids")
    private ApplicationIds applicationIds;
    @JsonProperty("dev_eui")
    private String devEui;
    @JsonProperty("join_eui")
    private String joinEui;
    @JsonProperty("dev_addr")
    private String devAddr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("device_id")
    public String getDeviceId() {
        return deviceId;
    }

    @JsonProperty("device_id")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @JsonProperty("application_ids")
    public ApplicationIds getApplicationIds() {
        return applicationIds;
    }

    @JsonProperty("application_ids")
    public void setApplicationIds(ApplicationIds applicationIds) {
        this.applicationIds = applicationIds;
    }

    @JsonProperty("dev_eui")
    public String getDevEui() {
        return devEui;
    }

    @JsonProperty("dev_eui")
    public void setDevEui(String devEui) {
        this.devEui = devEui;
    }

    @JsonProperty("join_eui")
    public String getJoinEui() {
        return joinEui;
    }

    @JsonProperty("join_eui")
    public void setJoinEui(String joinEui) {
        this.joinEui = joinEui;
    }

    @JsonProperty("dev_addr")
    public String getDevAddr() {
        return devAddr;
    }

    @JsonProperty("dev_addr")
    public void setDevAddr(String devAddr) {
        this.devAddr = devAddr;
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
