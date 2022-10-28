package com.codecool.spingboot_tasks.error_handling.repository;

import com.codecool.spingboot_tasks.error_handling.MyExceptions.MyResourceNotFoundException;
import com.codecool.spingboot_tasks.error_handling.MyExceptions.ProductNotFoundException;
import com.codecool.spingboot_tasks.error_handling.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {


    public List<Product> productList = new ArrayList<>();

    public List<Product> findAll() throws ProductNotFoundException{
        if(productList.isEmpty()){
            throw new ProductNotFoundException("There are no products.");
        }
        return productList;

    }

    public List<Product> findById(long id) throws ProductNotFoundException {
        if(productList.get((int)id)==null) {
            throw new ProductNotFoundException("There is no product with id:" + id);
        }
        return List.of(productList.get((int)id));

    }

    public void createProduct(Product product){
        productList.add(product);
        throw new MyResourceNotFoundException("There is no product with id: " + product.getId());
    }
}
