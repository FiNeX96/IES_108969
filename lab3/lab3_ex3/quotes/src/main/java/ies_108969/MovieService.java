package ies_108969;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository2;

    public Movie saveMovie(Movie movie) {
        return repository2.save(movie);
    }

    public List<Movie> saveMovies(List<Movie> movies) {
        return repository2.saveAll(movies);
    }

    public List<Movie> getMovies() {
        return repository2.findAll();
    }

    public Movie getMovieById(int id) {
        return repository2.findById(id).orElse(null);
    }

    public Movie getMovieByName(String title) {
        return repository2.findByTitle(title);
    }

    public String deleteMovie(int id) {
        repository2.deleteById(id);
        return "product removed !! " + id;
    }

    public Movie updateMovie(Movie movie) {
        Movie existingMovie = repository2.findById(movie.getId()).orElse(null);
        assert existingMovie != null;
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setYear(movie.getYear());
        return repository2.save(existingMovie);
    }
}