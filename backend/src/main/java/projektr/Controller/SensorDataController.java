package projektr.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projektr.Model.JsonModel;
import projektr.Model.Measurement;
import projektr.Model.SensorIdCommand;
import projektr.Service.SensorDataService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/sensordata")//, consumes = {"application/json"})
public class SensorDataController {

    private SensorDataService sds;

//    @GetMapping("/add")
//    public void test(){
//        System.out.println("Get works");
//    }

//    @GetMapping("/measurements")
//    public List<Measurement> getAllMeasurements(){
//        return sds.findAll();
//    }

    @GetMapping("/ids")
    public List<String> getSensorIds(){
        return sds.findSensorIds();
    }

    @PostMapping("/findlatest")
    public Measurement findLatestById(@RequestBody SensorIdCommand command){
        return sds.findLatestById(command);
    }

    @PostMapping("/all")
    public List<Measurement> findAllForId(@RequestBody SensorIdCommand command){
        return sds.findAllForId(command);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addData(@RequestBody JsonModel model){
        return sds.addData(model);
    }
}
