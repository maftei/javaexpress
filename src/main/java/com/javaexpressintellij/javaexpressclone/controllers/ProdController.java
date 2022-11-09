package com.javaexpressintellij.javaexpressclone.controllers;


import com.javaexpressintellij.javaexpressclone.models.Prod;
import com.javaexpressintellij.javaexpressclone.services.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController

public class ProdController {
    @Autowired
    private ProdService productService;

    @PostMapping("/createProd")
    public Prod createProd(@RequestBody  @Valid Prod product){

        return productService.create(product);
    }

    //creating list of products
    @PostMapping("/createProducts")
    public Iterable<Prod> createProducts(@RequestBody List<Prod> product) {
        return productService.insertListOfProducts(product);

    }
    //creating update method with PutMapping in dev branch
    @PutMapping (value="/updateProduct/{productId}")
    public void updateProd(@PathVariable ("productId") Long productId, @RequestBody Prod product){
            productService.updateProduct(productId,product);
    }

    @GetMapping("/allproductnames")
    public Iterable<Prod> retrieveProd(){
        return productService.getAllProducts();
    }

    @DeleteMapping(value="/deleteProduct/{productId}")
    public void deleteProd(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);

    }

    @GetMapping("/fetchProduct/{productId}")
    public Prod fetchProduct(@PathVariable("productId") Long productId){
        return productService.fetchProduct(productId);
    }

    @GetMapping("/product/{barCode}")
    public List<Prod> fetchProductByBarCode(@PathVariable("barCode") Integer barCode){
        return productService.fetchProductInfoBarCode(barCode);
    }
}
