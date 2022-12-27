package projektr.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projektr.Model.*;
import projektr.Repository.SensorDataRepository;

@Service
@AllArgsConstructor
public class SensorDataService {

    //SensorDataRepository sdr = new SensorDataRepository();
    private final SensorDataRepository sdr;

    public Iterable<Measurement> findAll() {
        return sdr.findAll();
    }

    public ResponseEntity<String> addData(JsonModel model){
        Data data = model.getData();
        UplinkMessage um = data.getUplinkMessage();
        DecodedPayload decodedPayload = um.getDecodedPayload();
        System.out.println("Sensor Id: " + data.getEndDeviceIds().getDeviceId());
        System.out.println("Sensor Name: " + data.getEndDeviceIds().getApplicationIds().getApplicationId());
        System.out.println("Time: " + data.getReceivedAt());
        System.out.println("------------Data below------------");
        System.out.println("Humidity: " + decodedPayload.getHumidity());
        System.out.println("Temp: " + decodedPayload.getTemperature());
        System.out.println("Pressure: " + decodedPayload.getPressure());
        System.out.println("Illuminance: " + decodedPayload.getIlluminance());
        System.out.println("uva: " + decodedPayload.getUva());
        System.out.println("uvb: " + decodedPayload.getUvb());
        System.out.println("uvindex: " + decodedPayload.getUVIndex());
        return new ResponseEntity<String>("Sensor data added", HttpStatus.ACCEPTED);
    }

}
