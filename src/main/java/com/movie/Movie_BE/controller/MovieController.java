package com.movie.Movie_BE.controller;


import com.movie.Movie_BE.dto.MovieDTO;
import com.movie.Movie_BE.entity.Movie;
import com.movie.Movie_BE.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //đánh dấu 1 controller, nơi chứa api
@CrossOrigin(origins = {"http://localhost:5173/"}) //be chấp nhận những url này
public class MovieController {
    //method
    //get

    @Autowired //để có thể xài, import từ bất cứ đâu, tự new instance
    MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity getMovies() { //ResponseEntity chuyển obj về json để front end render dc ra màn hình
        List<Movie> movieList = movieService.getMovies();
        return ResponseEntity.ok(movieList);
    }

    @PostMapping("movie")
    public ResponseEntity postMovie(@RequestBody Movie movie) {
        Movie movies = movieService.postMovie(movie);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity getMovieDetail(@PathVariable long movieId) { //ResponseEntity chuyển obj về json để front end render dc ra màn hình
        Movie movies = movieService.getMovieDetailById(movieId);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/movie-by-name")
    public ResponseEntity getMovieDetailByName(@RequestParam String movieName) { //ResponseEntity chuyển obj về json để front end render dc ra màn hình
        List<Movie> movies = movieService.getMovieDetailByName(movieName);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/add-data")
    public void addData() {
        movieService.addData();
    }

}
