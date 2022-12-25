package projektr.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import projektr.Model.Data;
import projektr.Model.DecodedPayload;
import projektr.Model.JsonModel;
import projektr.Model.UplinkMessage;

public class SensorDataService {

    public ResponseEntity<String> addData(JsonModel model){
        Data data = model.getData();
        UplinkMessage um = data.getUplinkMessage();
        DecodedPayload decodedPayload = um.getDecodedPayload();
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
