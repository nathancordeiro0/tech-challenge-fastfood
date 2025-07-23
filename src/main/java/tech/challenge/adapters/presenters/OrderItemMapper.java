package tech.challenge.adapters.presenters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import tech.challenge.adapters.presenters.helpers.ProductMapperHelper;
import tech.challenge.commons.dao.OrderItemDAO;
import tech.challenge.commons.dto.request.CreateOrderItemRequestV1;
import tech.challenge.commons.dto.response.OrderItemResponseV1;
import tech.challenge.entities.OrderItem;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ProductMapperHelper.class)
public interface OrderItemMapper {

    OrderItemDAO toDAO(OrderItem entity);

    OrderItem fromDaoToEntity(OrderItemDAO dao);

    @Mapping(target = "subTotalPrice", expression = "java(entity.getSubTotalPrice())")
    OrderItemResponseV1 toOrderItemResponseV1(OrderItem entity);

    @Mapping(source = "productId", target = "product", qualifiedByName = "ProductIdMapper")
    OrderItem fromRequestToEntity(CreateOrderItemRequestV1 requestV1);
}
