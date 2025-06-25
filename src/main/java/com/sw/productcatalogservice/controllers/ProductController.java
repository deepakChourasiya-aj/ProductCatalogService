package com.sw.productcatalogservice.controllers;

import com.sw.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        Product product = new Product();
        product.setId(1L);
        product.setName("Apple");
        product.setDescription("Iphone 16");
        product.setPrice(15.0);

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        return productList;
    }

}
