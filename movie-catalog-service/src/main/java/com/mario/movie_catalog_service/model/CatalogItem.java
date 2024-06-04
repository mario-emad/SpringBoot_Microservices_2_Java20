package com.mario.movie_catalog_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogItem {
    private String name;
    private String description;
    private int rating;
}
