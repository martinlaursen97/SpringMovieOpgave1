package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public String displayGreeting() {
        return "<h1>Welcome to my application</h1>";
    }

    public Movie getFirstMovie() {
        return movieRepository.getFirstMovie();
    }

    public Movie getRandomMovie() {
        return movieRepository.getRandomMovie();
    }

    public List<Movie> getTopTenPopularMovies() {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            movies.add(movieRepository.getRandomMovie());
        }

        Collections.sort(movies);
        return movies;
    }

    public List<Movie> getMovieByFilter(char character, int amount) {
        return movieRepository.getMovieByFilter(character, amount);
    }

    public int getMoviesAwardWinner() {
        return movieRepository.getMoviesAwardWinner();
    }

    public List<Movie> getMovieSequels(String g1, String g2) {
          return movieRepository.getMovieSequels(g1, g2);
    }

    public List<Movie> getComedyAwardWinners() {
        return movieRepository.getComedyAwardWinners();
    }
}
