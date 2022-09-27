package com.ordina.eventing.product.query;

import com.ordina.eventing.product.domain.Product;
import com.ordina.eventing.product.domain.Products;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductQueries {

    private Products products;

    public ProductQueries(Products products){
        this.products = products;
    }

    public List<Product> getAvailableProducts(){
        return this.products.getAvailableProducts();
    }

}
