package com.movie.Movie_BE.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data //getter & setter
@AllArgsConstructor //cấp cho t 1 constructor full tham số
@Entity //đánh dấu entity thì mới lưu xuống db dc
@NoArgsConstructor

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tự generate ra id tăng dần khi có data mới dc add
    private long id;
    private String name;
    private String image;

    //1 bộ phim thì chỉ có 1 đạo diễn => 1 nhiều
    //trick là cái one chỉ cái tk dc khởi tạo ngay dưới annotation (vd one là director, many là movie)
    //@JoinColumn là foreign key, để bên class có ToOne, or hiểu là lấy bên 1 bỏ qua nhiều (từ director qua movie)
    @ManyToOne
    @JoinColumn(name = "director_id")
    Information director;

    //1 phim có nhiều actors => nhiều nhiều
    @ManyToMany//tự generate cho mình bảng movie_actors, k cần phải tự tạo bảng bằng cách thêm entity movie_actors nữa
    List<Information> actors;
}
