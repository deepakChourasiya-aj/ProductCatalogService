package com.sw.productcatalogservice.controllers;

import com.sw.productcatalogservice.dtos.ProductDto;
import com.sw.productcatalogservice.models.Product;
import com.sw.productcatalogservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts(){
        return null;
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable("id") Long productId){
        return null;
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productDto;
    }

}
