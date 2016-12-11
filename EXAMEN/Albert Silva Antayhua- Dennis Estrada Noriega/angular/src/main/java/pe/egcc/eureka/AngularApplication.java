package pe.egcc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class AngularApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder
	configure(SpringApplicationBuilder application) {
		return application.sources(AngularApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AngularApplication.class, args);
	}
}