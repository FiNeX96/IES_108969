package ies_108969;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class GreetingController2 {
    
    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private static ObjectMapper mapper = new ObjectMapper();

	@GetMapping("/restgreet")
	public String greeting(@RequestParam(value = "name", required=false, defaultValue="Professor") String name) {
		Greeting g = new Greeting(counter.incrementAndGet(), String.format(template, name));
		try{
			return mapper.writeValueAsString(g);
		}
		catch(Exception e){
			return "Error: " + e.getMessage();
		}
	}
}
