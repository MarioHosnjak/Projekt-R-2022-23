package projektr.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projektr.Model.JsonModel;
import projektr.Service.SensorDataService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/sensordata")//, consumes = {"application/json"})
public class SensorDataController {

    //SensorDataService sds = new SensorDataService();
    private SensorDataService sds;

    @GetMapping("/add")
    public void test(){
        System.out.println("Get works");
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/measurements")
    ResponseEntity<?> getAllMeasurements() {
        return ResponseEntity.ok(sds.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addData(@RequestBody JsonModel model){
        return sds.addData(model);
    }
}
