package com.movieticket.entity;
import jakarta.persistence.*;
@Entity @Table(name="seats", uniqueConstraints=@UniqueConstraint(columnNames={"screen_id","seat_number"}))
public class Seat {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long seatId;
 @ManyToOne(optional=false) @JoinColumn(name="screen_id") private Screen screen;
 @Column(nullable=false) private String seatNumber; private String seatType;
 public Long getSeatId(){return seatId;} public void setSeatId(Long v){seatId=v;} public Screen getScreen(){return screen;} public void setScreen(Screen v){screen=v;} public String getSeatNumber(){return seatNumber;} public void setSeatNumber(String v){seatNumber=v;} public String getSeatType(){return seatType;} public void setSeatType(String v){seatType=v;}
}
