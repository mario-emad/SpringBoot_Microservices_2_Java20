package com.mario.movie_info_service.service;

import com.mario.movie_info_service.model.Movie;
import com.mario.movie_info_service.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public Movie getMovie(String movieId) {
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}
