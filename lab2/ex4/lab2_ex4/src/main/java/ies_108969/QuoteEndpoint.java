package ies_108969;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class QuoteEndpoint {

	private static ObjectMapper mapper = new ObjectMapper();

	@GetMapping("/api/quote")
	public String quote(Model model) {


		//System.out.println("Request à /api/quote");

		Quotes quotes = new Quotes();
		quotes.loadQuotes(); // load the quotes
		Quote randomQuote = quotes.getRandomQuote();

		try{
			return mapper.writeValueAsString(randomQuote);
		}
		catch(Exception e){
			return "Error: " + e.getMessage();
		}
	}

}
