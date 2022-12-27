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
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private OffsetDateTime time;

    @Column
    private Double humidity;

    @Column
    private Double illuminance;

    @Column
    private Double pressure;

    @Column
    private Double temperature;

    @Column
    private Double uva;

    @Column
    private Double uvb;

    @Column
    private Double uvindex;

    @Column(length = 40)
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensorId")
    private Sensor sensor;

}
