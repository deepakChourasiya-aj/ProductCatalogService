package com.sw.productcatalogservice.service;

import com.sw.productcatalogservice.dtos.SortParam;
import com.sw.productcatalogservice.dtos.SortType;
import com.sw.productcatalogservice.models.Product;
import com.sw.productcatalogservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> searchProducts(String query, Integer pageSize, Integer pageNumber, List<SortParam> sortParams){
        // Sort sortById = Sort.by("id").descending();
        // Sort overAllSort = Sort.by("price").descending().and(sortById);

        Sort sort = null;

        if(!sortParams.isEmpty()){
            for(int i=0;i<sortParams.size();i++){
                if(sortParams.get(i).getSortType().equals(SortType.ASC))
                    sort = sort.by(sortParams.get(i).getSortCriteria());
                else
                    sort = sort.by(sortParams.get(i).getSortCriteria()).descending();
            }
        }
        return productRepository.findByNameEquals(query, PageRequest.of(pageNumber,pageSize,sort));
    }
}
