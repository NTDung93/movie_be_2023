package com.movie.Movie_BE.repository;

import com.movie.Movie_BE.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//tất cả các thao tác dưới database đều xử lý trong đây
//tham số đầu là entity chứ k phải dto, kdl của khóa chính
public interface MovieRepositoy extends JpaRepository<Movie, Long>{
    Movie findMovieById(long id);

//    List<Movie> findMovieByNameContainingIgnoreCase(String name);

    @Query("select mv from Movie mv where mv.name like %?1% ")
    List<Movie> find(String keyword);
}


