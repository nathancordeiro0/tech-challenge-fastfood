package tech.challenge.commons.dto.response;

import lombok.*;
import tech.challenge.commons.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponseV1 {
    private UUID id;
    private UUID customerId;
    private Long orderNumber;
    private List<OrderItemResponseV1> orderItems;
    private OffsetDateTime orderDate;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private Boolean orderPaid;
}
