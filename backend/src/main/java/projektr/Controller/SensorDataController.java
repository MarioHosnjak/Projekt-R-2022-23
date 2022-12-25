package projektr.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projektr.Model.JsonModel;
import projektr.Service.SensorDataService;

@RestController
@RequestMapping(path = "/sensordata", consumes = {"application/json"})
public class SensorDataController {

    SensorDataService sds = new SensorDataService();

    @GetMapping("/add")
    public void test(){
        System.out.println("Get works");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addData(@RequestBody JsonModel model){
        return sds.addData(model);
    }
}
