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

    @CrossOrigin(origins = "*")
    @GetMapping("/ids")
    public List<String> getSensorIds(){
        return sds.findSensorIds();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/findlatest")
    public Measurement findLatestById(@RequestBody SensorIdCommand command){
        return sds.findLatestById(command);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/all")
    public List<Measurement> findAllForId(@RequestBody SensorIdCommand command){
        return sds.findAllForId(command);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<String> addData(@RequestBody JsonModel model){
        if(sds.deleteAllForDate().getStatusCode().is2xxSuccessful()){
            System.out.println("Old data successfully deleted");
        }else{
            System.out.println("Old data could not be deleted!");
        }
        return sds.addData(model);
    }
}
