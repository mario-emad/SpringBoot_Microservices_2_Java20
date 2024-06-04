package com.mario.movie_catalog_service.controller;

import com.mario.movie_catalog_service.model.CatalogItem;
import com.mario.movie_catalog_service.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movieCatalog")
@AllArgsConstructor
public class MovieCatalogController {

    private CatalogService catalogService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<CatalogItem>> getCatalog(@PathVariable("userId") String userId) {
        List<CatalogItem> catalogItems = catalogService.getCatalogItems(userId);
        return ResponseEntity.ok(catalogItems);
    }

}
