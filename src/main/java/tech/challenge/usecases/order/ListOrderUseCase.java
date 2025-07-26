package tech.challenge.usecases.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.challenge.commons.enums.OrderStatus;
import tech.challenge.commons.interfaces.gateways.OrderGatewayInterface;
import tech.challenge.commons.interfaces.gateways.OrderItemGatewayInterface;
import tech.challenge.entities.Order;
import tech.challenge.entities.OrderItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListOrderUseCase {

    private final OrderGatewayInterface orderGatewayInterface;
    private final OrderItemGatewayInterface orderItemGatewayInterface;

    public List<Order> execute() {
        var orders = new ArrayList<>(orderGatewayInterface.findAll());

        return orders.stream()
                .map(order -> {
                    List<OrderItem> orderItems = orderItemGatewayInterface.findAllByIdOrderId(order.getId());
                    return order.withOrderItems(orderItems);
                })
                .filter(item -> item.getStatus() != OrderStatus.FINISHED)
                .sorted(Comparator.comparing((Order o) -> o.getStatus().getOrder()).thenComparing(Order::getCreatedAt))
                .toList();
    }
}
