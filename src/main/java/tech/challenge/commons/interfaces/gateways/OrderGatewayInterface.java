package tech.challenge.commons.interfaces.gateways;

import tech.challenge.entities.Order;

import java.util.List;
import java.util.UUID;

public interface OrderGatewayInterface {
    List<Order> findAll();
    Order findById(UUID id);
    Order save(Order entity);
}
