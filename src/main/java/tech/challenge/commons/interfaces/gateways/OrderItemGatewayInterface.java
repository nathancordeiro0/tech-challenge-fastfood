package tech.challenge.commons.interfaces.gateways;

import tech.challenge.entities.OrderItem;

import java.util.List;
import java.util.UUID;

public interface OrderItemGatewayInterface {
    List<OrderItem> findAllByIdOrderId(UUID id);
    OrderItem save(OrderItem entity);
    List<OrderItem> saveAll(List<OrderItem> entityList);
}
