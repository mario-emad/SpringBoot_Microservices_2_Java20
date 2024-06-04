package com.mario.rating_data_service.controller;

import com.mario.rating_data_service.model.Rating;
import com.mario.rating_data_service.model.UserRatings;
import com.mario.rating_data_service.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingData")
@AllArgsConstructor
public class RatingDataController {

    private RatingService ratingService;

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return ratingService.getRating(movieId);
    }

    @GetMapping("/users/{userId}")
    public UserRatings getCatalog(@PathVariable("userId") String userId) {
        return ratingService.getUserRatings(userId);
    }

}
