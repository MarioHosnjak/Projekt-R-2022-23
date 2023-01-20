package projektr.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import projektr.Model.Measurement;

import javax.transaction.Transactional;
import java.util.List;

public interface SensorDataRepository extends CrudRepository<Measurement, Long> {

    @Override
    List<Measurement> findAll();

    @Query(value = "SELECT DISTINCT sensorid FROM measurement\n" +
            "ORDER BY sensorid ASC;", nativeQuery = true)
    List<String> findSensorIds();

    @Query(value = "SELECT * FROM measurement\n" +
            "WHERE sensorid = :sensorid\n" +
            "ORDER BY time DESC\n" +
            "LIMIT 1;", nativeQuery = true)
    Measurement findLatestById(@Param("sensorid") String sensorId);

    @Query(value = "SELECT * FROM measurement\n" +
            "WHERE sensorid = :sensorid\n" +
            "ORDER BY time DESC;", nativeQuery = true)
    List<Measurement> findAllForId(@Param("sensorid") String sensorId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM measurement \n" +
            "WHERE DATE(time) < CURRENT_DATE - 30", nativeQuery = true)
    void deleteAllForDate();
}
