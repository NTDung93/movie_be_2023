package com.movie.Movie_BE.dto;


import javax.persistence.Id;

//entity để lưu xuống database, dto để show ra và k có pass worrd, tránh rò rỉ password

public class Account {
    @Id
    private long id;
    private String name;
}
