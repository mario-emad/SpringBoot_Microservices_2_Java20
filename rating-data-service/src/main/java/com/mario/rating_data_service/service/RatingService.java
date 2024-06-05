package com.mario.rating_data_service.service;

import com.mario.rating_data_service.model.Rating;
import com.mario.rating_data_service.model.UserRatings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class RatingService {

    public UserRatings getUserRatings(String userId) {
        return new UserRatings(userId, Arrays.asList(
                new Rating("550", 10),
                new Rating("551", 5)
        ));
    }

}
