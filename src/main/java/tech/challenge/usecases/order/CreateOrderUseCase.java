package tech.challenge.usecases.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.challenge.commons.enums.OrderStatus;
import tech.challenge.commons.interfaces.gateways.OrderGatewayInterface;
import tech.challenge.commons.interfaces.gateways.OrderItemGatewayInterface;
import tech.challenge.commons.interfaces.gateways.ProductGatewayInterface;
import tech.challenge.entities.Order;
import tech.challenge.entities.OrderItem;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateOrderUseCase {

    private final OrderGatewayInterface orderGatewayInterface;
    private final OrderItemGatewayInterface orderItemGatewayInterface;
    private final ProductGatewayInterface productGatewayInterface;

    public Order execute(Order order) {
        var orderEntity = orderGatewayInterface.save(order.withStatus(OrderStatus.RECEIVED));

        List<OrderItem> orderItems = order.getOrderItems().stream().map(item -> item.withOrderId(orderEntity.getId())).toList();

        var savedOrderItems = orderItemGatewayInterface.saveAll(orderItems);

        var orderItemsWithProduct = savedOrderItems.stream()
                .map(orderItem -> {
                    var product = productGatewayInterface.findByOrderItemId(orderItem.getId());
                    return orderItem.withProduct(product);
                })
                .toList();

        return orderEntity.withOrderItems(orderItemsWithProduct);
    }
}
