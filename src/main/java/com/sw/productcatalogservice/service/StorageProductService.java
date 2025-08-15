package com.sw.productcatalogservice.service;

import com.sw.productcatalogservice.exceptions.ResourceNotFoundException;
import com.sw.productcatalogservice.models.Product;
import com.sw.productcatalogservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow(()-> new ResourceNotFoundException("Product not found with id " + id));
    }

    @Override
    public Product createProduct(Product product){
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(optionalProduct.isEmpty()) return productRepository.save(product);
        return optionalProduct.get();
    }

    @Override
    public Product replaceProduct(Product input,Long id){
        if(!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
        input.setId(id);
        return productRepository.save(input);
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product getProductBasedOnUserScope(Long userId, Long productId){

    }
}
