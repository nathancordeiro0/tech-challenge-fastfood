package tech.challenge.adapters.presenters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import tech.challenge.adapters.presenters.helpers.OrderItemMapperHelper;
import tech.challenge.commons.dao.OrderDAO;
import tech.challenge.commons.dto.request.CreateOrderRequestV1;
import tech.challenge.commons.dto.response.OrderResponseV1;
import tech.challenge.entities.Order;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = OrderItemMapperHelper.class)
public interface OrderMapper {

    OrderDAO toDAO(Order entity);

    Order fromDaoToEntity(OrderDAO dao);

    @Mapping(target = "totalPrice", expression = "java(entity.getTotalPrice())")
    OrderResponseV1 toOrderResponseV1(Order entity);

    @Mapping(source = "requestV1.orderItems", target = "orderItems", qualifiedByName = "orderItemsMapper")
    Order fromRequestToEntity(CreateOrderRequestV1 requestV1);
}
