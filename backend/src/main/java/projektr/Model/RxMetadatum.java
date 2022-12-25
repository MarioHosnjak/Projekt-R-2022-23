
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
    "gateway_ids",
    "timestamp",
    "rssi",
    "channel_rssi",
    "snr",
    "uplink_token",
    "channel_index",
    "received_at"
})
@Generated("jsonschema2pojo")
public class RxMetadatum {

    @JsonProperty("gateway_ids")
    private GatewayIds gatewayIds;
    @JsonProperty("timestamp")
    private Integer timestamp;
    @JsonProperty("rssi")
    private Integer rssi;
    @JsonProperty("channel_rssi")
    private Integer channelRssi;
    @JsonProperty("snr")
    private Double snr;
    @JsonProperty("uplink_token")
    private String uplinkToken;
    @JsonProperty("channel_index")
    private Integer channelIndex;
    @JsonProperty("received_at")
    private String receivedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("gateway_ids")
    public GatewayIds getGatewayIds() {
        return gatewayIds;
    }

    @JsonProperty("gateway_ids")
    public void setGatewayIds(GatewayIds gatewayIds) {
        this.gatewayIds = gatewayIds;
    }

    @JsonProperty("timestamp")
    public Integer getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("rssi")
    public Integer getRssi() {
        return rssi;
    }

    @JsonProperty("rssi")
    public void setRssi(Integer rssi) {
        this.rssi = rssi;
    }

    @JsonProperty("channel_rssi")
    public Integer getChannelRssi() {
        return channelRssi;
    }

    @JsonProperty("channel_rssi")
    public void setChannelRssi(Integer channelRssi) {
        this.channelRssi = channelRssi;
    }

    @JsonProperty("snr")
    public Double getSnr() {
        return snr;
    }

    @JsonProperty("snr")
    public void setSnr(Double snr) {
        this.snr = snr;
    }

    @JsonProperty("uplink_token")
    public String getUplinkToken() {
        return uplinkToken;
    }

    @JsonProperty("uplink_token")
    public void setUplinkToken(String uplinkToken) {
        this.uplinkToken = uplinkToken;
    }

    @JsonProperty("channel_index")
    public Integer getChannelIndex() {
        return channelIndex;
    }

    @JsonProperty("channel_index")
    public void setChannelIndex(Integer channelIndex) {
        this.channelIndex = channelIndex;
    }

    @JsonProperty("received_at")
    public String getReceivedAt() {
        return receivedAt;
    }

    @JsonProperty("received_at")
    public void setReceivedAt(String receivedAt) {
        this.receivedAt = receivedAt;
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
