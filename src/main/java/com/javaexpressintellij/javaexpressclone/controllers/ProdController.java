package com.javaexpressintellij.javaexpressclone.controllers;


import com.javaexpressintellij.javaexpressclone.models.Prod;
import com.javaexpressintellij.javaexpressclone.services.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdController {

    @Autowired
    private ProdService productService;

    @PostMapping("/createProd")
    public Prod createProd(@RequestBody Prod product){

        return productService.create(product);
    }

    //creating list of products
    @PostMapping("/createProducts")
    public Iterable<Prod> createProducts(@RequestBody List<Prod> product) {
        return productService.insertListOfProducts(product);

    }

    @PutMapping
    public void updateProd(){

    }

    @GetMapping("/retrieveProducts")
    public Iterable<Prod> retrieveProd(){
        return productService.getAllProducts();
    }

    @DeleteMapping
    public void deleteProd(){

    }

    @GetMapping("/fetchProduct/{productId}")
    public void fetchProdInformation(@PathVariable Long productId){
        productService.fetchProduct(productId);
    }
}
