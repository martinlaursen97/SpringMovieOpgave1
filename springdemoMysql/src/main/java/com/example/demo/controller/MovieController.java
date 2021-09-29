package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public String displayGreeting() {
        return movieService.displayGreeting();
    }

    @GetMapping("/getFirst")
    public Movie getFirstMovie() {
        return movieService.getFirstMovie();
    }

    @GetMapping("/getRandom")
    public Movie getRandomMovie() {
        return movieService.getRandomMovie();
    }

    @GetMapping("/getTenSortByPopularity")
    public List<Movie> getTopTenPopularMovies() {
        return movieService.getTopTenPopularMovies();
    }

    @GetMapping("/howManyWonAnAward")
    public int getMoviesAwardWinner() {
        return movieService.getMoviesAwardWinner();
    }

    @GetMapping("/filter")
    public List<Movie> getMoviesByFilter(@RequestParam char character, int amount) {
        return movieService.getMovieByFilter(character, amount);
    }

    @GetMapping("/howManySequels")
    public String getMovieSequels(@RequestParam String g1, String g2) {
        return movieService.getMovieSequels(g1, g2);
    }

    @GetMapping("/comedyAwardWinners")
    public List<Movie> getComedyAwardWinners() {
        return movieService.getComedyAwardWinners();
    }
}
