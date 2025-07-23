package tech.challenge.commons.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class OrderItemResponseV1 {
    private UUID id;
    private UUID orderId;
    private Integer quantity;
    private ProductResponseV1 product;
    private BigDecimal subTotalPrice;
}
