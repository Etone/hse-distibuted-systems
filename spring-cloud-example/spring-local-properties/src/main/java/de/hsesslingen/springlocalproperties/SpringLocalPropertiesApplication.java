package de.hsesslingen.springlocalproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class SpringLocalPropertiesApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringLocalPropertiesApplication.class, args);
	}


	@RestController
	public class RestGreeter{

		@Value("${application.greeting: Hello World!}")
		private String greeting;

		@GetMapping("/hello")
		public String greet(){
			return greeting;
		}
	}
}
