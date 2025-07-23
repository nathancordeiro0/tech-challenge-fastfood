package tech.challenge.entities;

import lombok.*;
import tech.challenge.commons.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private UUID id;
    private UUID customerId;
    private Long orderNumber;
    private List<OrderItem> orderItems = new ArrayList<>();
    private OffsetDateTime orderDate;
    private OffsetDateTime finishedDate;
    private OrderStatus status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public BigDecimal getTotalPrice() {
        return calculateTotalPrice();
    }

    private BigDecimal calculateTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem item : orderItems) {
            BigDecimal itemPrice = item.getProduct() != null && item.getProduct().getPrice() != null
                    ? item.getProduct().getPrice()
                    : BigDecimal.ZERO;

            BigDecimal quantity = item.getQuantity() != null
                    ? new BigDecimal(item.getQuantity())
                    : BigDecimal.ZERO;

            total = total.add(itemPrice.multiply(quantity));
        }

        return total;
    }
}
