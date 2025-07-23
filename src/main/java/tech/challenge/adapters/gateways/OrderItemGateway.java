package tech.challenge.adapters.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.challenge.adapters.presenters.OrderItemMapper;
import tech.challenge.commons.interfaces.datasource.OrderItemDataSource;
import tech.challenge.commons.interfaces.gateways.OrderItemGatewayInterface;
import tech.challenge.entities.OrderItem;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderItemGateway implements OrderItemGatewayInterface {

    private final OrderItemDataSource orderItemDataSource;
    private final OrderItemMapper mapper;

    @Override
    public List<OrderItem> findAllByIdOrderId(UUID id) {
        return orderItemDataSource.findAllByOrderId(id)
                .stream()
                .map(mapper::fromDaoToEntity)
                .toList();
    }

    @Override
    public OrderItem save(OrderItem entity) {
        var newOrderItem = mapper.toDAO(entity);

        return mapper.fromDaoToEntity(orderItemDataSource.save(newOrderItem));
    }

    @Override
    public List<OrderItem> saveAll(List<OrderItem> entityList) {
        var newOrderItemList = entityList.stream().map(mapper::toDAO).toList();

        return orderItemDataSource.saveAll(newOrderItemList)
                .stream()
                .map(mapper::fromDaoToEntity)
                .toList();
    }
}
