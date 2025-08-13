package com.sw.productcatalogservice.controllers;

import com.sw.productcatalogservice.dtos.SearchRequestDto;
import com.sw.productcatalogservice.models.Product;
import com.sw.productcatalogservice.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/search")
@RestController
public class SearchController {
    @Autowired
    private SearchService searchService;

    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto){
        return searchService.searchProducts(searchRequestDto.getQuery(),searchRequestDto.getPageSize(),searchRequestDto.getPageNumber(),searchRequestDto.getSortParams());
    }
}
