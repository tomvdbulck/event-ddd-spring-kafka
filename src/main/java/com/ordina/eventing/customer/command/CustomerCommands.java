package com.ordina.eventing.customer.command;

import com.ordina.eventing.customer.domain.*;
import org.springframework.stereotype.Component;

@Component
public class CustomerCommands {

    private Orders orders;
    private ShoppingCarts shoppingCarts;

    public CustomerCommands(Orders orders, ShoppingCarts shoppingCarts){
        this.orders = orders;
        this.shoppingCarts = shoppingCarts;
    }

    public void addProductToShoppingCart(Customer customer, Product product){
        ShoppingCart shoppingCart = shoppingCarts.get(customer.getCode());
        if (shoppingCart == null){
            shoppingCart = new ShoppingCart(customer);
        }
        shoppingCart.updateProduct(product);

        shoppingCarts.update(shoppingCart);
    }

    public void placeOrder(Customer customer){
        ShoppingCart shoppingCart = shoppingCarts.get(customer.getCode());

        Order order = shoppingCart.order();
        orders.save(order);

        shoppingCarts.update(shoppingCart);
    }
}
