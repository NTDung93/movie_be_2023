package com.movie.Movie_BE.repository;

import com.movie.Movie_BE.entity.Information;
import com.movie.Movie_BE.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Information, Long> {
}
