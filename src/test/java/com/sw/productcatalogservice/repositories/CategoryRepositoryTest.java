package com.sw.productcatalogservice.repositories;

import com.sw.productcatalogservice.models.Category;
import com.sw.productcatalogservice.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Transactional
    public void testLoading(){
        Optional<Category> categoryOptional = categoryRepository.findById(2L);
//        for(Product p : categoryOptional.get().getProducts()){
//            System.out.println(p.getName()+"\t"+p.getDescription());
//        }
    }
}
