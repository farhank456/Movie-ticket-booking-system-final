package com.movieticket.config;

import com.movieticket.entity.*; import com.movieticket.repository.*; import org.springframework.boot.CommandLineRunner; import org.springframework.stereotype.Component; import java.time.*;

@Component
public class DataInitializer implements CommandLineRunner {
 private final UserRepository users; private final MovieRepository movies; private final TheatreRepository theatres; private final ScreenRepository screens; private final SeatRepository seats; private final ShowRepository shows;
 public DataInitializer(UserRepository u,MovieRepository m,TheatreRepository t,ScreenRepository s,SeatRepository se,ShowRepository sh){users=u;movies=m;theatres=t;screens=s;seats=se;shows=sh;}
 public void run(String... args){
  if(users.findByEmail("admin@movieticket.com").isEmpty()){User a=new User();a.setName("Administrator");a.setEmail("admin@movieticket.com");a.setPassword("admin123");a.setRole(Role.ADMIN);users.save(a);}
  if(users.findByEmail("user@movieticket.com").isEmpty()){User u=new User();u.setName("Demo User");u.setEmail("user@movieticket.com");u.setPassword("user123");u.setRole(Role.USER);users.save(u);}
  if(movies.count()>0) return;
  Movie m1=new Movie();m1.setTitle("Avengers: Endgame");m1.setDescription("Earth's heroes unite for a final battle.");m1.setGenre("Action");m1.setDuration(181);m1.setLanguage("English");m1.setPosterUrl("https://image.tmdb.org/t/p/w500/or06FN3Dka5tukK1e9sl16pB3iy.jpg");movies.save(m1);
  Movie m2=new Movie();m2.setTitle("Inception");m2.setDescription("A thief enters dreams to steal secrets.");m2.setGenre("Sci-Fi");m2.setDuration(148);m2.setLanguage("English");m2.setPosterUrl("https://image.tmdb.org/t/p/w500/oYuLEt3zVCKq57qu2F8dT7NIa6f.jpg");movies.save(m2);
  Theatre t=new Theatre();t.setName("CineMax Mumbai");t.setLocation("Andheri, Mumbai");theatres.save(t);
  Screen s=new Screen();s.setTheatre(t);s.setScreenName("Screen 1");s.setTotalSeats(30);screens.save(s);
  for(int i=1;i<=30;i++){Seat seat=new Seat();seat.setScreen(s);seat.setSeatNumber((char)('A'+(i-1)/10)+String.valueOf((i-1)%10+1));seat.setSeatType(i<=10?"PREMIUM":"REGULAR");seats.save(seat);}
  for(Movie m:new Movie[]{m1,m2}){Show sh=new Show();sh.setMovie(m);sh.setScreen(s);sh.setShowDate(LocalDate.now());sh.setShowTime(LocalTime.of(18,30));sh.setPrice(250.0);shows.save(sh);}
 }
}
