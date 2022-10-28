package com.codecool.spingboot_tasks.error_handling.MyExceptions;

import com.codecool.spingboot_tasks.error_handling.model.Product;

public class ProductNotFoundException extends RuntimeException {
    private String errorMsg;
    public ProductNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
