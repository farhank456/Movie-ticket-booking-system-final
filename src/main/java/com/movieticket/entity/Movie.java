package com.movieticket.entity;

import jakarta.persistence.*;

@Entity @Table(name="movies")
public class Movie {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long movieId;
    @Column(nullable=false) private String title;
    @Column(columnDefinition="TEXT") private String description;
    private String genre; private Integer duration; private String language; private String posterUrl;
    public Long getMovieId(){return movieId;} public void setMovieId(Long v){movieId=v;}
    public String getTitle(){return title;} public void setTitle(String v){title=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public String getGenre(){return genre;} public void setGenre(String v){genre=v;}
    public Integer getDuration(){return duration;} public void setDuration(Integer v){duration=v;}
    public String getLanguage(){return language;} public void setLanguage(String v){language=v;}
    public String getPosterUrl(){return posterUrl;} public void setPosterUrl(String v){posterUrl=v;}
}
