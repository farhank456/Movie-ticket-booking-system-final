package com.movieticket.entity;
import jakarta.persistence.*;
@Entity @Table(name="screens")
public class Screen {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long screenId;
 @ManyToOne(optional=false) @JoinColumn(name="theatre_id") private Theatre theatre;
 @Column(nullable=false) private String screenName; private Integer totalSeats;
 public Long getScreenId(){return screenId;} public void setScreenId(Long v){screenId=v;} public Theatre getTheatre(){return theatre;} public void setTheatre(Theatre v){theatre=v;} public String getScreenName(){return screenName;} public void setScreenName(String v){screenName=v;} public Integer getTotalSeats(){return totalSeats;} public void setTotalSeats(Integer v){totalSeats=v;}
}
