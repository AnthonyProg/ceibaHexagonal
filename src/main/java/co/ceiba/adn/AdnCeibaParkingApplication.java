package co.ceiba.adn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.ceiba.adn"})
public class AdnCeibaParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdnCeibaParkingApplication.class, args);
	}

}
