package com.sw.productcatalogservice.service;

import com.sw.productcatalogservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirdPartyProductService implements IProductService{
    @Override
    public Product getProductById(Long id){
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }
}
