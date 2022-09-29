package com.ordina.eventing.customer.repository;

import com.ordina.eventing.customer.domain.ShoppingCart;
import com.ordina.eventing.customer.domain.ShoppingCarts;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ShoppingCartRepository implements ShoppingCarts {

    private HashMap<String, ShoppingCart> shoppingCarts;

    public ShoppingCartRepository(){
        this.shoppingCarts = new HashMap<>();
    }


    @Override
    public void add(ShoppingCart shoppingCart) {
        shoppingCarts.put(shoppingCart.getCustomerCode(), shoppingCart);
    }

    @Override
    public ShoppingCart get(String customerCode) {
        return shoppingCarts.get(customerCode);
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        shoppingCarts.put(shoppingCart.getCustomerCode(), shoppingCart);
    }
}
