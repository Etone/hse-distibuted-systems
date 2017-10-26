package de.hse.synchasynchexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SynchAsynchExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SynchAsynchExampleApplication.class, args);
		SynchExample.callRest();
	}
}
