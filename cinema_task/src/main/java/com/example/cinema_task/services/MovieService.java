package com.example.cinema_task.services;

import com.example.cinema_task.models.Movie;
import com.example.cinema_task.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    // MVP
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie newMovie){
        return movieRepository.save(newMovie);
    }

    // Extension
    public Movie updateMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }



}
