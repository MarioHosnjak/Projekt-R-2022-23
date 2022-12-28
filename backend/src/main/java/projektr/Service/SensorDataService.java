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

    private final SensorDataRepository sdr;

    public Iterable<Measurement> findAll() {
        return sdr.findAll();
    }

    public ResponseEntity<String> addData(JsonModel model){
        UplinkMessage um = model.getUplinkMessage();
        DecodedPayload decodedPayload = um.getDecodedPayload();
        System.out.println("Sensor Id: " + model.getEndDeviceIds().getDeviceId());
        System.out.println("Time: " + model.getReceivedAt());
        System.out.println("------------Data below------------");
        System.out.println("Humidity: " + decodedPayload.getHumidity());
        System.out.println("Temp: " + decodedPayload.getTemperature());
        System.out.println("Pressure: " + decodedPayload.getPressure());
        System.out.println("Illuminance: " + decodedPayload.getIlluminance());
        System.out.println("uva: " + decodedPayload.getUva());
        System.out.println("uvb: " + decodedPayload.getUvb());
        System.out.println("uvindex: " + decodedPayload.getUVIndex());
        Measurement m = new Measurement(decodedPayload.getHumidity(), decodedPayload.getIlluminance(), "location",
                decodedPayload.getPressure(), model.getEndDeviceIds().getDeviceId(), decodedPayload.getTemperature(),
                model.getReceivedAt(), decodedPayload.getUva(), decodedPayload.getUvb(), decodedPayload.getUVIndex());
        sdr.save(m);
        return new ResponseEntity<String>("Sensor data added", HttpStatus.ACCEPTED);
    }

}
