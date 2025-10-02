package com.sw.productcatalogservice.controllers;

import com.sw.productcatalogservice.dtos.ProductDto;
import com.sw.productcatalogservice.models.Product;
import com.sw.productcatalogservice.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private IProductService productService;

    @Test
    public void testGetProductById_WithValidId_RunSuccessfully(){
        // Arrange ..
        Long id = 1L;
        Product product = new Product();
        product.setId(id);
        product.setName("Iphone17");

        when(productService.getProductById(id)).thenReturn(product);

        // Act
        ResponseEntity<ProductDto> productDtoResponseEntity = productController.getProductById(id);

        // Assertion
        assertNotNull(productDtoResponseEntity);
        assertNotNull(productDtoResponseEntity.getBody());
        assertEquals("Iphone17", productDtoResponseEntity.getBody().getName());
        assertEquals(id,productDtoResponseEntity.getBody().getId());
        verify(productService,times(1)).getProductById(id);

    }

    @Test
    public void testGetProductById_WithNagativeId_ThrowsIllegalArgumentException(){
        //  Act and assert..
        assertThrows(IllegalArgumentException.class,()-> productController.getProductById(-1L));
        verify(productService,times(0)).getProductById(-1L);
    }

    @Test
    public void testGetProductById_WithZeroId_ThrowsIllegalArgumentException(){
        // Act and Assert..
        Exception exception = assertThrows(IllegalArgumentException.class,()->productController.getProductById(-1L));
        assertEquals("Product Id not found",exception.getMessage());
        verify(productService,times(0)).getProductById(0L);

    }
}
