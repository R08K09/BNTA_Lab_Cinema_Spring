package com.example.cinema_task.repositories;

import com.example.cinema_task.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
