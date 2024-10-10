package trex.autonomous.terrarover;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TerraroverApplication {

	public static void main ( String[] args ) {
		SpringApplication.run(TerraroverApplication.class, args);
		log.info("Terrarover application started on http://localhost:9001");
	}

}
