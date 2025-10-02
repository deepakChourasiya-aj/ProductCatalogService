package com.sw.productcatalogservice.repositories;

import com.sw.productcatalogservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    Page<Product> findByNameEquals(String name, Pageable pageable);

    List<Product> findProductByPriceBetween(Double lower, Double higher);

    List<Product> findAllByOrderByPrice();

    @Query("SELECT p.name FROM Product p where p.id=:id")
    String getProductNameById(Long id);

}
