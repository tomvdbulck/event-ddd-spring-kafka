package com.ordina.eventing.product.repository;

import com.ordina.eventing.product.domain.Product;
import com.ordina.eventing.product.domain.Products;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository implements Products {
    @Override
    public List<Product> getAvailableProducts() {
        return Arrays.asList(
                Product.builder()
                    .code("001")
                    .name("Google Pixel 6")
                    .description("A phone")
                    .price(BigDecimal.valueOf(500))
                .build(),Product.builder()
                        .code("002")
                        .name("Google Pixel 7")
                        .description("A slightly better phone")
                        .price(BigDecimal.valueOf(700))
                        .build(),
                Product.builder()
                        .code("003")
                        .name("Google Pixel 8")
                        .description("A much better phone")
                        .price(BigDecimal.valueOf(950))
                        .build());
    }
}
