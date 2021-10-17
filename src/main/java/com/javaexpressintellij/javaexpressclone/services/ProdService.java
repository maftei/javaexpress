package com.javaexpressintellij.javaexpressclone.services;

import com.javaexpressintellij.javaexpressclone.models.Prod;
import com.javaexpressintellij.javaexpressclone.repos.ProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdService {

    @Autowired
    private ProdRepository productRepository;

    public Prod create(Prod product) {
        Prod dbProduct = productRepository.save(product);
        return dbProduct;
    }

    public Iterable<Prod> insertListOfProducts(List<Prod> product) {
        Iterable<Prod> dbproducts = productRepository.saveAll(product);
        return dbproducts;
    }

    public Iterable<Prod> getAllProducts() {
        return productRepository.findAll();
    }
}
