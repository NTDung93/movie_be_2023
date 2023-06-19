package com.movie.Movie_BE.dto;

import javax.persistence.Id;

public class MovieDTO {

    @Id
    private Long id;
    private String name;
    private String image;
    private String actorName;
    private int year;
}
