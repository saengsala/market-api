package com.market.market.controller;

import com.market.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private static final String DATA_NOT_FOUND = "Data not found";

    @Autowired
    private ProductService productService;

    @RequestMapping(
            value = "/api/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllProducts() {
        List products = productService.getAllProducts();
        if(products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(DATA_NOT_FOUND);
        }
        return ResponseEntity.ok(products);
    }
}
