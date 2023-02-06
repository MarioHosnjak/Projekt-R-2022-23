
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
    "decoded_payload"
})
@Generated("jsonschema2pojo")
public class UplinkMessage {

    @JsonProperty("decoded_payload")
    private DecodedPayload decodedPayload;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("decoded_payload")
    public DecodedPayload getDecodedPayload() {
        return decodedPayload;
    }

    @JsonProperty("decoded_payload")
    public void setDecodedPayload(DecodedPayload decodedPayload) {
        this.decodedPayload = decodedPayload;
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
