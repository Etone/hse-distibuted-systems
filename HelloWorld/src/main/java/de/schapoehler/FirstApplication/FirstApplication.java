package de.schapoehler.FirstApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

	@RestController
	class Controller {

		int visits;

		@GetMapping("/hello")
		public String hello(){
			return "Hello, you are the " + ++visits + " Visitor";
		}

		@DeleteMapping("/reset")
		public String resetCounter(){
			visits = 0;
			return "Counter reset to 0";
		}

		@PostMapping("/set/{new}")
		public String setCounter(@PathVariable("new") int newValue) {
			visits = newValue;
			return "Counter set to " + newValue;
		}

		@PutMapping("/echo/{data}")
		public String echoData(@PathVariable("data") String data ) {
			return data;
		}
	}
}
