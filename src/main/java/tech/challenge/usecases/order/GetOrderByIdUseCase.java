package tech.challenge.usecases.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.challenge.commons.interfaces.gateways.OrderGatewayInterface;
import tech.challenge.commons.interfaces.gateways.OrderItemGatewayInterface;
import tech.challenge.entities.Order;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetOrderByIdUseCase {

    private final OrderGatewayInterface orderGatewayInterface;
    private final OrderItemGatewayInterface orderItemGatewayInterface;

    public Order execute(UUID id) {
        var order = orderGatewayInterface.findById(id);

        order.setOrderItems(orderItemGatewayInterface.findAllByIdOrderId(order.getId()));

        return order;
    }
}
