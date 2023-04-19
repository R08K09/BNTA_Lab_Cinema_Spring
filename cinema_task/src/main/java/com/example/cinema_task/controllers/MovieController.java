package com.example.cinema_task.controllers;

import com.example.cinema_task.models.Movie;
import com.example.cinema_task.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    // GET /movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // GET /movies/{id}
    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Optional<Movie> movie = movieService.getMovieById(id);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // POST /movies
    @PostMapping
    public ResponseEntity<Movie> newMovie(@RequestBody Movie movie){
        Movie addedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
    }

    // PUT /movies/{id}
    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        movie.setId(id);
        movieService.updateMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    // DELETE /movies/{id}
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
