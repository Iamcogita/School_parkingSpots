package academy.mindswap.School_parkingSpots.School_parkingSpots;


import academy.mindswap.School_parkingSpots.School_parkingSpots.Logger.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SchoolParkingSpotsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolParkingSpotsApplication.class);

	public static void main(String[] args) {
		LOGGER.info("hello world");
		SpringApplication.run(SchoolParkingSpotsApplication.class, args);
	}

}
