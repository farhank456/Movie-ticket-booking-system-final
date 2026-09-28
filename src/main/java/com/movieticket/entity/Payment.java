package com.movieticket.entity;
import jakarta.persistence.*; import java.time.LocalDateTime; import java.util.UUID;
@Entity @Table(name="payments")
public class Payment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long paymentId;
 @OneToOne(optional=false) @JoinColumn(name="booking_id", unique=true) private Booking booking;
 @Column(nullable=false, unique=true) private String transactionId=UUID.randomUUID().toString();
 private String paymentMethod; private Double amount; @Enumerated(EnumType.STRING) private PaymentStatus paymentStatus; private LocalDateTime paymentDate;
 public Long getPaymentId(){return paymentId;} public void setPaymentId(Long v){paymentId=v;} public Booking getBooking(){return booking;} public void setBooking(Booking v){booking=v;} public String getTransactionId(){return transactionId;} public void setTransactionId(String v){transactionId=v;} public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;} public Double getAmount(){return amount;} public void setAmount(Double v){amount=v;} public PaymentStatus getPaymentStatus(){return paymentStatus;} public void setPaymentStatus(PaymentStatus v){paymentStatus=v;} public LocalDateTime getPaymentDate(){return paymentDate;} public void setPaymentDate(LocalDateTime v){paymentDate=v;}
}
