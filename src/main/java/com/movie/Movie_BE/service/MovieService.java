package com.movie.Movie_BE.service;

import com.movie.Movie_BE.dto.MovieDTO;
import com.movie.Movie_BE.entity.Information;
import com.movie.Movie_BE.entity.Movie;
import com.movie.Movie_BE.repository.ActorRepository;
import com.movie.Movie_BE.repository.MovieRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //đánh dấu đây là service, nơi xử lý logic
public class MovieService {
    @Autowired //để khỏi new cái instance
    MovieRepositoy movieRepositoy;

    @Autowired
    ActorRepository actorRepository;

    public List<Movie> getMovies() {
        List<Movie> list = movieRepositoy.findAll();
        return list;
    }

    public List<Movie> postMovies(List<Movie> movies) {
        List<Movie> newMovies = movieRepositoy.saveAll(movies);
        return newMovies;
    }

    public Movie postMovie(Movie movie) {
        Movie newMovie = movieRepositoy.save(movie);
        return newMovie;
    }

    public Movie getMovieDetailById(long movieId) {
        Movie movies = movieRepositoy.findMovieById(movieId);
        return movies;
    }

    public List<Movie> getMovieDetailByName(String movieName) {
        List<Movie> movies = movieRepositoy.find(movieName);
        return movies;
    }

    public void addData() {
        Movie movie = movieRepositoy.findMovieById(1);
        List<Information> actors = actorRepository.findAll();
        movie.setActors(actors);
        movieRepositoy.save(movie);
    }
}
