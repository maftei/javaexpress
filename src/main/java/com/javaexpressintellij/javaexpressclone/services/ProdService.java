package com.javaexpressintellij.javaexpressclone.services;

import com.javaexpressintellij.javaexpressclone.exceptions.ProductNotFoundException;
import com.javaexpressintellij.javaexpressclone.models.Prod;
import com.javaexpressintellij.javaexpressclone.repos.ProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Prod fetchProduct(Long productId) {
//        Optional<Prod> optionalProduct = productRepository.findById(productId);
//        if (optionalProduct.isPresent()) {
//            Prod product = optionalProduct.get();
//            return product;
//        }else
//            {
//                System.out.println("No such product in db :" + productId);
//                return null;
//            }
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product id not found in database"));
    }

    public Prod updateProduct(Long prodId, Prod inputProduct ) {

        Prod dbProduct=fetchProduct(prodId);
        if(dbProduct!=null){
            dbProduct.setProdName(inputProduct.getProdName());
            dbProduct.setProdDescription(inputProduct.getProdDescription());

            return productRepository.save(dbProduct);
        }
        return null;
    }

    public void deleteProduct(Long productid) {

        Prod dbProductInfo=fetchProduct(productid);
        if(dbProductInfo!=null)
        {
            productRepository.deleteById(productid);
        }
    }

    public List<Prod> fetchProductInfoBarCode(Integer barCode) {

        return productRepository.findByBarCode(barCode);
    }

    public List<String> fetchAllProductName() {

        return  productRepository.fetchAllProductName();
    }
}
