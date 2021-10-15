package com.example.demo.controller;

import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

     private final MovieService movieService;

     @Autowired
     public MovieController(MovieService movieService) {
         this.movieService = movieService;
     }

     @GetMapping()
     public String displayGreeting() {
         return "index";
     }

     @GetMapping("/getFirst")
     public String getFirstMovie(Model model) {
         model.addAttribute("movie", movieService.getFirstMovie());
         return "movie";
     }

    @GetMapping("/getRandom")
    public String getRandomMovie(Model model) {
         model.addAttribute("movie", movieService.getRandomMovie());
         return "movie";
    }

    @GetMapping("/getTenSortByPopularity")
    public String getTopTenPopularMovies(Model model) {
         model.addAttribute("movies", movieService.getTopTenPopularMovies());
         return "movies";
    }

    @GetMapping("/howManyWonAnAward")
    public String getMoviesAwardWinner(Model model) {
         model.addAttribute("num", movieService.getMoviesAwardWinner());
         return "number";
    }

    @GetMapping("/filter")
    public String getMoviesByFilter(@RequestParam char character, int amount, Model model) {
         model.addAttribute("movies", movieService.getMovieByFilter(character, amount));
         return "movies";
    }

    @GetMapping("/howManySequels")
    public String getMovieSequels(@RequestParam String g1, String g2, Model model) {
         model.addAttribute("movies", movieService.getMovieSequels(g1, g2));
         return "movies";
    }

    @GetMapping("/comedyAwardWinners")
    public String getComedyAwardWinners(Model model) {
         model.addAttribute("movies", movieService.getComedyAwardWinners());
         return "movies";
    }
}
