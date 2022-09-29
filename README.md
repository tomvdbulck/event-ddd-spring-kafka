# event-ddd-spring-kafka
Event Domain Driven Design with Spring

## Getting Started
Clone and create a new project in Intellij.
Make sure java 17 is installed.

Disable the JMX agent for Spring Boot.

Run the application and the `FakeActor' will start to generate orders.

## Exercise

Implement the following events in the `warehouse` bounded context.

### Shipment is ready to be shipped
Send a command to the Shipment that it has been made ready in the warehouse.

Update the status of the `Order`to `READY_TO_BE_SHIPPED` and notify the customer
(For the notification: just log a line with the customer name and the order reference)

### Shipment has been shipped
Send a command to the Shipment that it has been made shipped.

Update the status of the `Order` to `SHIPPED` and again notify the customer.

### Shipment is delivered
Send a command to the Shipment that it has been made delivered to the customer.

Update the status of the `Order` to `DELIVERED` and again notify the customer.

### Note:
You can base yourself on the 'CustomerCommands' for the commands.
For the event handling look at how the 'Order' broadcasts the event.
And how the 'OrderDomainEventHandler' catches those events for the warehouse.

Implement the logic in `FakeActor.java`


