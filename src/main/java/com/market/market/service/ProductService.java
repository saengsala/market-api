package com.market.market.service;

import com.market.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List getAllProducts() {
        List products = new ArrayList(productRepository.findAll());
        return products;
    }
}
