package ies_108969;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ShowsEndpoint {

    private static ObjectMapper mapper = new ObjectMapper();
    public HashMap<String,Integer> movies = new HashMap<String,Integer>();

    @GetMapping("/api/shows")
    public String shows(Model model) {

        //System.out.println("Request à /api/shows");

        movies.clear();

        Quotes quotes = new Quotes();
        quotes.loadQuotes(); // load the quotes

        for (Quote quote : quotes.quotes) {
            movies.put(quote.movie,quote.code);
        }

        try {
            return mapper.writeValueAsString(movies);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

    }

}
