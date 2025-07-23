package tech.challenge.adapters.presenters.helpers;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import tech.challenge.adapters.presenters.OrderItemMapper;
import tech.challenge.commons.dto.request.CreateOrderItemRequestV1;
import tech.challenge.entities.OrderItem;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderItemMapperHelper {

    private final OrderItemMapper mapper;

    @Named("orderItemsMapper")
    public List<OrderItem> map(List<CreateOrderItemRequestV1> orderItems) {
        return orderItems.stream().map(mapper::fromRequestToEntity).toList();
    }
}
