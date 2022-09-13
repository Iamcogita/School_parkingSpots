package academy.mindswap.School_parkingSpots.School_parkingSpots;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SchoolParkingSpotsApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(SchoolParkingSpotsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SchoolParkingSpotsApplication.class, args);
	}

}
