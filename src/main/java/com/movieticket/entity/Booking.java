package com.movieticket.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="bookings")
public class Booking {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long bookingId;
 @ManyToOne(optional=false) @JoinColumn(name="user_id") private User user;
 @ManyToOne(optional=false) @JoinColumn(name="show_id") private Show show;
 private LocalDateTime bookingDate; private Double totalAmount;
 @Enumerated(EnumType.STRING) private BookingStatus bookingStatus=BookingStatus.CONFIRMED;
 public Long getBookingId(){return bookingId;} public void setBookingId(Long v){bookingId=v;} public User getUser(){return user;} public void setUser(User v){user=v;} public Show getShow(){return show;} public void setShow(Show v){show=v;} public LocalDateTime getBookingDate(){return bookingDate;} public void setBookingDate(LocalDateTime v){bookingDate=v;} public Double getTotalAmount(){return totalAmount;} public void setTotalAmount(Double v){totalAmount=v;} public BookingStatus getBookingStatus(){return bookingStatus;} public void setBookingStatus(BookingStatus v){bookingStatus=v;}
}
