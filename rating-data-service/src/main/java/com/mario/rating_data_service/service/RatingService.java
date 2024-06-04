package com.mario.rating_data_service.service;

import com.mario.rating_data_service.model.Rating;
import com.mario.rating_data_service.model.UserRatings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class RatingService {

    public Rating getRating(String movieId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1", 10),
                new Rating("2", 5));

        return ratings.stream().filter(rating -> rating.getId().equals(movieId)).findFirst().get();
    }

    public UserRatings getUserRatings(String userId) {
        return new UserRatings(Arrays.asList(
                new Rating("1", 10),
                new Rating("2", 5)
        ));
    }

}
