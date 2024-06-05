package com.mario.movie_info_service.controller;

import com.mario.movie_info_service.model.Movie;
import com.mario.movie_info_service.service.MovieInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieInfo")
@AllArgsConstructor
public class MovieInfoController {

    private MovieInfoService movieInfoService;

    @GetMapping("/{movieId}")
    public Movie getCatalog(@PathVariable("movieId") String movieId) {
        return movieInfoService.getMovie(movieId);


    }

}
