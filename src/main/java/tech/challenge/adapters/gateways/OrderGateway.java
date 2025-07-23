package tech.challenge.adapters.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.challenge.adapters.presenters.OrderMapper;
import tech.challenge.commons.interfaces.datasource.OrderDataSource;
import tech.challenge.commons.interfaces.gateways.OrderGatewayInterface;
import tech.challenge.entities.Order;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderGateway implements OrderGatewayInterface {

    private final OrderDataSource orderDataSource;
    private final OrderMapper mapper;

    @Override
    public List<Order> findAll() {
        return orderDataSource.findAll()
                .stream()
                .map(mapper::fromDaoToEntity)
                .toList();
    }

    @Override
    public Order save(Order entity) {
        var savedOrder = mapper.toDAO(entity);

        return mapper.fromDaoToEntity(orderDataSource.save(savedOrder));
    }
}
