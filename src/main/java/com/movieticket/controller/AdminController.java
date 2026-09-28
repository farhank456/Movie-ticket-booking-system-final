package com.movieticket.controller;
import com.movieticket.entity.*; import com.movieticket.repository.*; import jakarta.servlet.http.HttpSession; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import java.time.*;
@Controller @RequestMapping("/admin") public class AdminController {
 private final MovieRepository movies; private final TheatreRepository theatres; private final ScreenRepository screens; private final SeatRepository seats; private final ShowRepository shows; private final BookingRepository bookings;
 public AdminController(MovieRepository m,TheatreRepository t,ScreenRepository s,SeatRepository se,ShowRepository sh,BookingRepository b){movies=m;theatres=t;screens=s;seats=se;shows=sh;bookings=b;}
 private boolean admin(HttpSession s){User u=(User)s.getAttribute("user");return u!=null&&u.getRole()==Role.ADMIN;}
 @GetMapping public String dashboard(Model m,HttpSession s){if(!admin(s))return "redirect:/login";m.addAttribute("movieCount",movies.count());m.addAttribute("theatreCount",theatres.count());m.addAttribute("showCount",shows.count());m.addAttribute("bookingCount",bookings.count());return "admin/dashboard";}
 @GetMapping("/movies") public String movies(Model m,HttpSession s){if(!admin(s))return "redirect:/login";m.addAttribute("movies",movies.findAll());return "admin/movies";}
 @GetMapping("/movies/new") public String newMovie(Model m,HttpSession s){if(!admin(s))return "redirect:/login";m.addAttribute("movie",new Movie());return "admin/movie-form";}
 @PostMapping("/movies/save") public String saveMovie(@ModelAttribute Movie movie,HttpSession s){if(admin(s))movies.save(movie);return "redirect:/admin/movies";}
 @PostMapping("/movies/delete/{id}") public String deleteMovie(@PathVariable Long id,HttpSession s){if(admin(s))movies.deleteById(id);return "redirect:/admin/movies";}
 @GetMapping("/theatres") public String theatres(Model m,HttpSession s){if(!admin(s))return "redirect:/login";m.addAttribute("theatres",theatres.findAll());return "admin/theatres";}
 @PostMapping("/theatres/save") public String saveTheatre(@ModelAttribute Theatre t,HttpSession s){if(admin(s))theatres.save(t);return "redirect:/admin/theatres";}
 @GetMapping("/shows") public String showList(Model m,HttpSession s){if(!admin(s))return "redirect:/login";m.addAttribute("shows",shows.findAllByOrderByShowDateAscShowTimeAsc());m.addAttribute("movies",movies.findAll());m.addAttribute("screens",screens.findAll());return "admin/shows";}
 @PostMapping("/shows/save") public String saveShow(@RequestParam Long movieId,@RequestParam Long screenId,@RequestParam String showDate,@RequestParam String showTime,@RequestParam Double price,HttpSession s){if(admin(s)){Show sh=new Show();sh.setMovie(movies.findById(movieId).orElseThrow());sh.setScreen(screens.findById(screenId).orElseThrow());sh.setShowDate(LocalDate.parse(showDate));sh.setShowTime(LocalTime.parse(showTime));sh.setPrice(price);shows.save(sh);}return "redirect:/admin/shows";}
 @PostMapping("/shows/delete/{id}") public String deleteShow(@PathVariable Long id,HttpSession s){if(admin(s))shows.deleteById(id);return "redirect:/admin/shows";}
 @GetMapping("/bookings") public String bookings(Model m,HttpSession s){if(!admin(s))return "redirect:/login";m.addAttribute("bookings",bookings.findAllByOrderByBookingDateDesc());return "admin/bookings";}
}
