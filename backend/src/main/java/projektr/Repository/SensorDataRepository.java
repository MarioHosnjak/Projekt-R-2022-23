package projektr.Repository;


import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projektr.Model.Measurement;

@Repository
public interface SensorDataRepository extends CrudRepository<Measurement, Integer>{

    Iterable<Measurement> findAll();
}
