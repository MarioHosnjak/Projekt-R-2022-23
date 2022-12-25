
package projektr.Model;

import java.util.HashMap;
import java.util.List;
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
    "session_key_id",
    "f_port",
    "frm_payload",
    "decoded_payload",
    "rx_metadata",
    "settings",
    "received_at",
    "confirmed",
    "consumed_airtime",
    "version_ids",
    "network_ids"
})
@Generated("jsonschema2pojo")
public class UplinkMessage {

    @JsonProperty("session_key_id")
    private String sessionKeyId;
    @JsonProperty("f_port")
    private Integer fPort;
    @JsonProperty("frm_payload")
    private String frmPayload;
    @JsonProperty("decoded_payload")
    private DecodedPayload decodedPayload;
    @JsonProperty("rx_metadata")
    private List<RxMetadatum> rxMetadata = null;
    @JsonProperty("settings")
    private Settings settings;
    @JsonProperty("received_at")
    private String receivedAt;
    @JsonProperty("confirmed")
    private Boolean confirmed;
    @JsonProperty("consumed_airtime")
    private String consumedAirtime;
    @JsonProperty("version_ids")
    private VersionIds versionIds;
    @JsonProperty("network_ids")
    private NetworkIds networkIds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("session_key_id")
    public String getSessionKeyId() {
        return sessionKeyId;
    }

    @JsonProperty("session_key_id")
    public void setSessionKeyId(String sessionKeyId) {
        this.sessionKeyId = sessionKeyId;
    }

    @JsonProperty("f_port")
    public Integer getfPort() {
        return fPort;
    }

    @JsonProperty("f_port")
    public void setfPort(Integer fPort) {
        this.fPort = fPort;
    }

    @JsonProperty("frm_payload")
    public String getFrmPayload() {
        return frmPayload;
    }

    @JsonProperty("frm_payload")
    public void setFrmPayload(String frmPayload) {
        this.frmPayload = frmPayload;
    }

    @JsonProperty("decoded_payload")
    public DecodedPayload getDecodedPayload() {
        return decodedPayload;
    }

    @JsonProperty("decoded_payload")
    public void setDecodedPayload(DecodedPayload decodedPayload) {
        this.decodedPayload = decodedPayload;
    }

    @JsonProperty("rx_metadata")
    public List<RxMetadatum> getRxMetadata() {
        return rxMetadata;
    }

    @JsonProperty("rx_metadata")
    public void setRxMetadata(List<RxMetadatum> rxMetadata) {
        this.rxMetadata = rxMetadata;
    }

    @JsonProperty("settings")
    public Settings getSettings() {
        return settings;
    }

    @JsonProperty("settings")
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    @JsonProperty("received_at")
    public String getReceivedAt() {
        return receivedAt;
    }

    @JsonProperty("received_at")
    public void setReceivedAt(String receivedAt) {
        this.receivedAt = receivedAt;
    }

    @JsonProperty("confirmed")
    public Boolean getConfirmed() {
        return confirmed;
    }

    @JsonProperty("confirmed")
    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    @JsonProperty("consumed_airtime")
    public String getConsumedAirtime() {
        return consumedAirtime;
    }

    @JsonProperty("consumed_airtime")
    public void setConsumedAirtime(String consumedAirtime) {
        this.consumedAirtime = consumedAirtime;
    }

    @JsonProperty("version_ids")
    public VersionIds getVersionIds() {
        return versionIds;
    }

    @JsonProperty("version_ids")
    public void setVersionIds(VersionIds versionIds) {
        this.versionIds = versionIds;
    }

    @JsonProperty("network_ids")
    public NetworkIds getNetworkIds() {
        return networkIds;
    }

    @JsonProperty("network_ids")
    public void setNetworkIds(NetworkIds networkIds) {
        this.networkIds = networkIds;
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
