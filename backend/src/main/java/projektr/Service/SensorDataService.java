package projektr.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projektr.Model.*;
import projektr.Repository.SensorDataRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class SensorDataService {

    private final SensorDataRepository sdr;

//    public List<Measurement> findAll() {
//        return sdr.findAll();
//    }

    public List<String> findSensorIds(){
        return sdr.findSensorIds();
    }

    public Measurement findLatestById(SensorIdCommand command){
        String sensorId = command.getSensorId();
        return sdr.findLatestById(sensorId);
    }

    public List<Measurement> findAllForId(SensorIdCommand command){
        String sensorId = command.getSensorId();
        return sdr.findAllForId(sensorId);
    }

    public ResponseEntity<String> addData(JsonModel model){
        UplinkMessage um = model.getUplinkMessage();
        DecodedPayload decodedPayload = um.getDecodedPayload();
        String[] time = model.getReceivedAt().split("\\.");
        String timestr = time[0];
        LocalDateTime timesql = LocalDateTime.parse(timestr);
        System.out.println("Sensor Id: " + model.getEndDeviceIds().getDeviceId());
        System.out.println("Time: " + timestr);
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
                timesql, decodedPayload.getUva(), decodedPayload.getUvb(), decodedPayload.getUVIndex());
        sdr.save(m);
        return new ResponseEntity<String>("Sensor data added", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> deleteAllForDate(){
        try{
            sdr.deleteAllForDate();
        }catch(Exception e){
            return new ResponseEntity<String>("Old data could not be deleted!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("Old data successfully deleted", HttpStatus.OK);
    }

}
