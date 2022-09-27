package com.ordina.eventing.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Slf4j
public class FakeCustomer {

    public FakeCustomer(){

    }

    @Scheduled(fixedRate = 5_000L)
    public void placeOrders(){
        log.info("place a random order");


    }


}
