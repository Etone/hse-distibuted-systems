package de.hse.synchasynchexample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Corvin on 25.10.2017.
 */
@RestController
public class SynchExample {

    //Get REST Mapping
    @GetMapping("/getSomething")
    public String getSomething(){
        return "something";
    }

    //calling REST APIs within Code
    public static void callRest(){
        RestTemplate template = new RestTemplate();
        String url = "http://localhost:8080/getSomething";

        ResponseEntity<String> response = template.getForEntity(url, String.class);

        System.out.println("Result of calling REST API: " + response.getBody());
    }
}
