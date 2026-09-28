package com.movieticket.entity;
import jakarta.persistence.*;
@Entity @Table(name="theatres")
public class Theatre {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long theatreId;
 @Column(nullable=false) private String name; private String location;
 public Long getTheatreId(){return theatreId;} public void setTheatreId(Long v){theatreId=v;}
 public String getName(){return name;} public void setName(String v){name=v;} public String getLocation(){return location;} public void setLocation(String v){location=v;}
}
