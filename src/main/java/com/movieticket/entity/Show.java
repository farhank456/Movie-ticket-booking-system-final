package com.movieticket.entity;
import jakarta.persistence.*; import java.time.LocalDate; import java.time.LocalTime;
@Entity @Table(name="shows")
public class Show {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long showId;
 @ManyToOne(optional=false) @JoinColumn(name="movie_id") private Movie movie;
 @ManyToOne(optional=false) @JoinColumn(name="screen_id") private Screen screen;
 @Column(nullable=false) private LocalDate showDate; @Column(nullable=false) private LocalTime showTime; @Column(nullable=false) private Double price;
 public Long getShowId(){return showId;} public void setShowId(Long v){showId=v;} public Movie getMovie(){return movie;} public void setMovie(Movie v){movie=v;} public Screen getScreen(){return screen;} public void setScreen(Screen v){screen=v;} public LocalDate getShowDate(){return showDate;} public void setShowDate(LocalDate v){showDate=v;} public LocalTime getShowTime(){return showTime;} public void setShowTime(LocalTime v){showTime=v;} public Double getPrice(){return price;} public void setPrice(Double v){price=v;}
}
