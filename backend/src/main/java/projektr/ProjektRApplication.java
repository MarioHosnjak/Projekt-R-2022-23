package projektr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) // dodano jer trenutno jos nemamo bazu podataka
@SpringBootApplication
public class ProjektRApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektRApplication.class, args);
	}

}
