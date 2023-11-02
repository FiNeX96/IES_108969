package ies_108969;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository repository2;

    public Quote saveQuote(Quote Quote) {
        return repository2.save(Quote);
    }

    public List<Quote> saveQuotes(List<Quote> Quotes) {
        return repository2.saveAll(Quotes);
    }

    public List<Quote> getQuotes() {
        return repository2.findAll();
    }

    public Quote getQuoteById(int id) {
        return repository2.findById(id).orElse(null);
    }


    public String deleteQuote(int id) {
        repository2.deleteById(id);
        return "product removed !! " + id;
    }

}
