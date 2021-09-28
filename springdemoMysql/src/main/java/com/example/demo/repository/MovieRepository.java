package com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private ResultSet getResultSet(String query) {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    private Movie getMovie(String query) {
        ResultSet resultSet = getResultSet(query);
        Movie movie = null;

        try {
            while (resultSet.next()) {
                movie = new Movie(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getString(7));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movie;
    }

    private List<Movie> getMovies(String query) {
        ResultSet resultSet = getResultSet(query);
        List<Movie> movies = new ArrayList<>();

        try {
            while (resultSet.next()) {

                Movie movie = new Movie(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getString(7)
                );

                movies.add(movie);

            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }

    public Movie getFirstMovie() {
        return getMovie("SELECT * FROM movies LIMIT 1");
    }

    public Movie getRandomMovie() {
        return getMovie("SELECT * FROM movies ORDER BY RAND() LIMIT 1");
    }

    public List<Movie> getTopTenPopularMovies() {
        return getMovies("SELECT * FROM movies ORDER BY  popularity DESC LIMIT 10;");
    }

    public int getMoviesAwardWinner() {
        return getMovie("SELECT count(*) as id, title, year, length, subject, popularity, awards  FROM movies WHERE awards = 'Yes';").getId();
    }

    public List<Movie> getMovieByFilter(char character, int amount) {
        return getMovies("SELECT * FROM movies WHERE length(title) - length(REPLACE(title, '"
                + character + "', '')) = "
                + amount + ";");
    }

    public List<Movie> getMovieSequels(String g1, String g2) {
        return getMovies("SELECT id, title, year, AVG(length), subject, popularity, awards FROM movies WHERE subject " +
                "= \""+g1+"\" or subject " +
                "= \""+g2+"\" GROUP BY subject ORDER BY AVG(length) DESC");
    }

    public List<Movie> getComedyAwardWinners() {
        return getMovies("SELECT * FROM movies WHERE awards = 'yes' AND subject = 'Comedy';");
    }
}
