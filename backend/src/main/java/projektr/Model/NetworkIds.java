
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
    "net_id",
    "tenant_id",
    "cluster_id",
    "cluster_address"
})
@Generated("jsonschema2pojo")
public class NetworkIds {

    @JsonProperty("net_id")
    private String netId;
    @JsonProperty("tenant_id")
    private String tenantId;
    @JsonProperty("cluster_id")
    private String clusterId;
    @JsonProperty("cluster_address")
    private String clusterAddress;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("net_id")
    public String getNetId() {
        return netId;
    }

    @JsonProperty("net_id")
    public void setNetId(String netId) {
        this.netId = netId;
    }

    @JsonProperty("tenant_id")
    public String getTenantId() {
        return tenantId;
    }

    @JsonProperty("tenant_id")
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @JsonProperty("cluster_id")
    public String getClusterId() {
        return clusterId;
    }

    @JsonProperty("cluster_id")
    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    @JsonProperty("cluster_address")
    public String getClusterAddress() {
        return clusterAddress;
    }

    @JsonProperty("cluster_address")
    public void setClusterAddress(String clusterAddress) {
        this.clusterAddress = clusterAddress;
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
