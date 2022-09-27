package com.ordina.eventing.customer;

import com.ordina.eventing.customer.command.CustomerCommands;
import com.ordina.eventing.customer.domain.Customer;
import com.ordina.eventing.product.domain.Product;
import com.ordina.eventing.product.query.ProductQueries;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
@Slf4j
public class FakeCustomer {

    private CustomerCommands customerCommands;

    private ProductQueries productQueries;

    private Customer customer;

    public FakeCustomer(CustomerCommands customerCommands, ProductQueries productQueries){
        this.customerCommands = customerCommands;
        this.productQueries = productQueries;

        customer = new Customer("1", "Tom");
    }

    @Scheduled(fixedRate = 5_000L)
    public void placeOrders(){
        log.info("place a random order");

        List<Product> productList = productQueries.getAvailableProducts();
        log.info("The customer can choose from the following products {}", productList);

        Product selectedProduct = productList.get(0);

        log.info("Choose a phone");
        com.ordina.eventing.customer.domain.Product productToOrder = com.ordina.eventing.customer.domain.Product.builder()
                .amount(1)
                .price(selectedProduct.getPrice())
                .code(selectedProduct.getCode())
                .description(selectedProduct.getDescription())
                .name(selectedProduct.getName())
                .build();
        customerCommands.addProductToShoppingCart(customer, productToOrder);

        log.info("I want 2 phones");
        productToOrder.updateAmount(2);
        customerCommands.addProductToShoppingCart(customer, productToOrder);

        log.info("customer will now place order");
        customerCommands.placeOrder(customer);



    }


}
