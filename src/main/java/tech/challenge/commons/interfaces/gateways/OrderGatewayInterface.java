package tech.challenge.commons.interfaces.gateways;

import tech.challenge.entities.Order;

import java.util.List;

public interface OrderGatewayInterface {
    List<Order> findAll();
    Order save(Order entity);
}
