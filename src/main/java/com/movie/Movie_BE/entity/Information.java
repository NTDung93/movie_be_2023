package com.movie.Movie_BE.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data //getter & setter
@AllArgsConstructor //cấp cho t 1 constructor full tham số
@Entity //đánh dấu entity thì mới lưu xuống db dc
@NoArgsConstructor
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tự generate ra id tăng dần khi có data mới dc add
    private long id;
    private String avatarURL;
    private String name;

    //1 đạo diễn có thể có nhiều phim => 1 nhiều
    @OneToMany(mappedBy = "director")
    @JsonIgnore
    List<Movie> moviesOfDirector;

    //1 actors đóng nhiều phim => nhiều
    @ManyToMany(mappedBy = "actors")
    //tự generate cho mình bảng movie_actors, k cần phải tự tạo bảng bằng cách thêm entity movie_actors nữa
    @JsonIgnore
    List<Movie> moviesOfActor;
}
