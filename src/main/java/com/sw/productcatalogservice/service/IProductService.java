package com.sw.productcatalogservice.service;

import com.sw.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);

    Product createProduct(Product product);

    Product replaceProduct(Product product,Long id);

    List<Product> getAllProducts();

    Product getProductDetailsBasedOnUserScope(Long userId, Long productId);

    Product getProductBasedOnUserScope(Long userId, Long productId);
}
