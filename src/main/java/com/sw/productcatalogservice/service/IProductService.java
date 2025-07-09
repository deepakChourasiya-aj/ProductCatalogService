package com.sw.productcatalogservice.service;

import com.sw.productcatalogservice.models.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);

    Product createProduct(Product product);

    Product replaceProduct(Product product,Long id);

    List<Product> getAllProducts();
}
