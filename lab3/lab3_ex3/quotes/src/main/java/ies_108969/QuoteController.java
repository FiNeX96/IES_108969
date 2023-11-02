package ies_108969;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
public class QuoteController {

    @Autowired
    private QuoteService quote_service;
    @Autowired
    private MovieService movie_service;


    @PostMapping("/addQuote")
    public Quote addQuote(@RequestBody Quote quote) {
        return quote_service.saveQuote(quote);
    }

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie) {
        return movie_service.saveMovie(movie);
    }

    @GetMapping("/quotes")
    public List<Quote> findAllQuotes() {
        return quote_service.getQuotes();
    }

    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return movie_service.getMovies();
    }

    @GetMapping("/quotes/{id}")
    public Quote findQuoteById(@PathVariable int id) {
        return quote_service.getQuoteById(id);
    }

    @GetMapping("/movies/{id}")
    public Movie findMovieById(@PathVariable int id) {
        return movie_service.getMovieById(id);
    }




    

}