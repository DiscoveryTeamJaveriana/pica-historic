package co.edu.javeriana.discovery.pica.historic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PicaHistoricApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicaHistoricApplication.class, args);
	}

}
