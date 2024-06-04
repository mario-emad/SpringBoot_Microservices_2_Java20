package com.mario.movie_catalog_service.service;

import com.mario.movie_catalog_service.model.CatalogItem;
import com.mario.movie_catalog_service.model.Movie;
import com.mario.movie_catalog_service.model.UserRatings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogService {

    private RestTemplate restTemplate;
//    private WebClient.Builder webClientBuilder;

    public List<CatalogItem> getCatalogItems(String userId) {
        UserRatings userRatings = restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingData/users/" + userId, UserRatings.class);

        return userRatings.getUserRatings().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movieInfo/" + userId, Movie.class);
//            Movie movie = webClientBuilder
//                    .build()
//                    .get()
//                    .uri("http://localhost:8082/movieInfo/" + userId)
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();
            return movie != null ? new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating()) : null;
        }).toList();
    }

}
