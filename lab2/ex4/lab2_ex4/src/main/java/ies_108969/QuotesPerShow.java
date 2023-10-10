package ies_108969;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

@RestController
public class QuotesPerShow {

	private static ObjectMapper mapper = new ObjectMapper();
	public ArrayList<Quote> quotes = new ArrayList<Quote>();

	@GetMapping("/api/quotes")
	public String quote(@RequestParam(name="show", required=true) String show_id, Model model) {

		int id_show = Integer.parseInt(show_id);

		this.quotes.clear();

		//System.out.println("SHOW ID = " + id_show);
		Quotes quotes = new Quotes();
		quotes.loadQuotes(); // load the quotes

		for (Quote quote : quotes.quotes) {
           if (quote.code == id_show){
			   this.quotes.add(quote);
		   }
        }

        try {
            return mapper.writeValueAsString(this.quotes);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
	}

}
