package com.sw.productcatalogservice.dtos;

import com.sw.productcatalogservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;

    private String description;

    private Double price;

    private String imageUrl;

    private Category category;
}
