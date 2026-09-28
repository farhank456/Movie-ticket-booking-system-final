package com.movieticket.service;

import com.movieticket.entity.*; import com.movieticket.repository.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime; import java.util.*;

@Service
public class BookingService {
 private final BookingRepository bookings; private final BookingSeatRepository bookingSeats; private final PaymentRepository payments; private final ShowRepository shows; private final SeatRepository seats; private final UserRepository users;
 public BookingService(BookingRepository b,BookingSeatRepository bs,PaymentRepository p,ShowRepository s,SeatRepository se,UserRepository u){bookings=b;bookingSeats=bs;payments=p;shows=s;seats=se;users=u;}
 @Transactional public Booking create(Long userId,Long showId,List<Long> seatIds,String paymentMethod){
  if(seatIds==null||seatIds.isEmpty()) throw new IllegalArgumentException("Select at least one seat.");
  Show show=shows.findById(showId).orElseThrow(); User user=users.findById(userId).orElseThrow();
  Set<Long> requested=new LinkedHashSet<>(seatIds); List<Long> occupied=bookingSeats.findBookedSeatIds(showId); for(Long id:requested) if(occupied.contains(id)) throw new IllegalArgumentException("One or more selected seats are already booked.");
  List<Seat> selected=seats.findAllById(requested); if(selected.size()!=requested.size()) throw new IllegalArgumentException("Invalid seat selection.");
  Booking b=new Booking(); b.setUser(user); b.setShow(show); b.setBookingDate(LocalDateTime.now()); b.setBookingStatus(BookingStatus.CONFIRMED); b.setTotalAmount(show.getPrice()*selected.size()); bookings.save(b);
  for(Seat seat:selected){BookingSeat bs=new BookingSeat();bs.setBooking(b);bs.setSeat(seat);bs.setPrice(show.getPrice());bookingSeats.save(bs);}
  Payment p=new Payment();p.setBooking(b);p.setPaymentMethod(paymentMethod==null?"UPI":paymentMethod);p.setAmount(b.getTotalAmount());p.setPaymentStatus(PaymentStatus.SUCCESS);p.setPaymentDate(LocalDateTime.now());payments.save(p); return b;
 }
 @Transactional public void cancel(Long bookingId,Long userId){Booking b=bookings.findById(bookingId).orElseThrow(); if(!b.getUser().getUserId().equals(userId)) throw new IllegalArgumentException("Not allowed."); b.setBookingStatus(BookingStatus.CANCELLED); bookings.save(b); payments.findByBookingBookingId(bookingId).ifPresent(p->{p.setPaymentStatus(PaymentStatus.REFUNDED);payments.save(p);});}
 public List<Long> bookedSeats(Long showId){return bookingSeats.findBookedSeatIds(showId);}
}
