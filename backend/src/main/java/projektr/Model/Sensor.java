package projektr.Model;

import javax.persistence.*;

//import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Sensor {

    @Id
    @Column(nullable = false, updatable = false, length = 20)
    private String sensorId;

    @Column(nullable = false, length = 35)
    private String sensorName;

    @OneToMany(mappedBy = "sensor")
    private Set<Measurement> sensorMeasurements;
}
