package com.movieticket.controller;
import com.movieticket.entity.*; import com.movieticket.repository.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api") public class ApiController {
 private final MovieRepository movies; private final ShowRepository shows; public ApiController(MovieRepository m,ShowRepository s){movies=m;shows=s;}
 @GetMapping("/movies") public List<Movie> movies(){return movies.findAll();}
 @GetMapping("/movies/{id}") public Movie movie(@PathVariable Long id){return movies.findById(id).orElseThrow();}
 @GetMapping("/shows") public List<Show> shows(){return shows.findAll();}
}
