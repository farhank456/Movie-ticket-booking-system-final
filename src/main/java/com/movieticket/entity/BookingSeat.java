package com.movieticket.entity;
import jakarta.persistence.*;
@Entity @Table(name="booking_seats", uniqueConstraints=@UniqueConstraint(columnNames={"booking_id","seat_id"}))
public class BookingSeat {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long bookingSeatId;
 @ManyToOne(optional=false) @JoinColumn(name="booking_id") private Booking booking;
 @ManyToOne(optional=false) @JoinColumn(name="seat_id") private Seat seat;
 private Double price;
 public Long getBookingSeatId(){return bookingSeatId;} public void setBookingSeatId(Long v){bookingSeatId=v;} public Booking getBooking(){return booking;} public void setBooking(Booking v){booking=v;} public Seat getSeat(){return seat;} public void setSeat(Seat v){seat=v;} public Double getPrice(){return price;} public void setPrice(Double v){price=v;}
}
