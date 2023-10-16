package sise.rest.vet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="sise.rest.vet.entities")
public class VeterinariaRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaRest1Application.class, args);
	}

}
