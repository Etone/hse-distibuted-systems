package de.hse.springdataexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
@RestController
public class SpringDataExampleApplication {

	@Autowired
	private GreetingRepository greetingRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataExampleApplication.class, args);
	}

	@GetMapping("/listAll")
	public String listAll(){
		return greetingRepository.findAll().toString();
	}

	@PostMapping("/add/{greeting}")
	public String addGreeting(@PathVariable("greeting") String greeting){
		Greeting g = new Greeting(greeting);
		greetingRepository.save(g);
		return "Added Greeting " + g + " to Database";
	}
}


//Entity Class
@Entity
class Greeting{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String greeting;


	//Needed for JPA
	public Greeting() {
	}

	public Greeting(String greeting) {
		this.greeting = greeting;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String toString() {
		return "Greeting{" +
				"id=" + id +
				", greeting='" + greeting + '\'' +
				'}';
	}
}

interface GreetingRepository extends CrudRepository<Greeting, Long>{

}
