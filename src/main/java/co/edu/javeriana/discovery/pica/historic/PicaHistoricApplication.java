package co.edu.javeriana.discovery.pica.historic;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class PicaHistoricApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicaHistoricApplication.class, args);
	}

	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
