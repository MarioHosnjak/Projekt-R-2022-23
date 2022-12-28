package projektr.Repository;

import org.springframework.data.repository.CrudRepository;
import projektr.Model.Measurement;

public interface SensorDataRepository extends CrudRepository<Measurement, Long> {

    @Override
    Iterable<Measurement> findAll();
}
