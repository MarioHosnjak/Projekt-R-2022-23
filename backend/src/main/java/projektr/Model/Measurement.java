package projektr.Model;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Measurement {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "humidity")
    private Double humidity;

    @Column(name = "illuminance")
    private Double illuminance;

    @Column(name="location", length = 40)
    private String location;

    @Column(name = "pressure")
    private Double pressure;

    @Column(name="sensorid", nullable = false)
    private String sensorId;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "uva")
    private Double uva;

    @Column(name = "uvb")
    private Double uvb;

    @Column(name = "uvindex")
    private Double uvindex;

    public Measurement(Double humidity, Double illuminance, String location, Double pressure, String sensorId, Double temperature, String time, Double uva, Double uvb, Double uvindex) {
        this.humidity = humidity;
        this.illuminance = illuminance;
        this.location = location;
        this.pressure = pressure;
        this.sensorId = sensorId;
        this.temperature = temperature;
        this.time = time;
        this.uva = uva;
        this.uvb = uvb;
        this.uvindex = uvindex;
    }
}
