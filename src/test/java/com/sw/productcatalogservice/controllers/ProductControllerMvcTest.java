package com.sw.productcatalogservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sw.productcatalogservice.dtos.ProductDto;
import com.sw.productcatalogservice.models.Product;
import com.sw.productcatalogservice.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllProducts_RunSuccessfully() throws Exception {
        // Arrange
        Product product = new Product();
        product.setId(1L);
        product.setName("Mac Book Pro");

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productService.getAllProducts()).thenReturn(productList);

        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("Mac Book Pro");
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(productDto);

        String response = objectMapper.writeValueAsString(productDtoList);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(response));

    }

    @Test
    public void testCreateProduct_RunSuccessfully() throws Exception {
        Product product = new Product();
        product.setId(1L);
        product.setName("Mac Book Pro");
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("Mac Book Pro");

        String productDtoString = objectMapper.writeValueAsString(productDto);

        // Act and Assert..here..
        mockMvc.perform(post("/products")
                    .content(productDtoString)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(productDtoString));
    }


}
