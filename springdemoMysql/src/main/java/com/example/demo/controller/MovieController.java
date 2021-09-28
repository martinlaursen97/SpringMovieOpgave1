package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    @ResponseBody
    public String displayGreeting() {
        return movieService.displayGreeting();
    }

    @GetMapping(path = "/getFirst")
    @ResponseBody
    public Movie getFirstMovie() {
        return movieService.getFirstMovie();
    }

    @GetMapping(path = "/getRandom")
    @ResponseBody
    public Movie getRandomMovie() {
        return movieService.getRandomMovie();
    }

    @GetMapping(path = "/getTenSortByPopularity")
    @ResponseBody
    public List<Movie> getTopTenPopularMovies() {
        return movieService.getTopTenPopularMovies();
    }

    @GetMapping(path = "/howManyWonAnAward")
    @ResponseBody
    public int getMoviesAwardWinner() {
        return movieService.getMoviesAwardWinner();
    }

    @GetMapping(path = "/filter")
    @ResponseBody
    public List<Movie> getMoviesByFilter(@RequestParam char character, int amount) {
        return movieService.getMovieByFilter(character, amount);
    }

    @GetMapping(path = "/howManySequels")
    @ResponseBody
    public String getMovieSequels(@RequestParam String g1, String g2) {
        return movieService.getMovieSequels(g1, g2);
    }

    @GetMapping(path = "/comedyAwardWinners")
    @ResponseBody
    public List<Movie> getComedyAwardWinners() {
        return movieService.getComedyAwardWinners();
    }
}
