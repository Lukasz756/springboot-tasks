package com.codecool.spingboot_tasks.error_handling.controller;

import com.codecool.spingboot_tasks.error_handling.model.Product;
import com.codecool.spingboot_tasks.error_handling.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void createProduct(@ModelAttribute int id, String name, int price){
        Product product = new Product(id,name,price);
        productService.createProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {

        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public List<Product> getProducts(@PathVariable long id) {

        return productService.getProduct(id);
    }

}
