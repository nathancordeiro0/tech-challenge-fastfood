package tech.challenge.entities;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private UUID id;
    private Integer quantity;
    private Product product;
    private UUID orderId;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public BigDecimal getSubTotalPrice() {
        return calculateSubTotalPrice();
    }

    private BigDecimal calculateSubTotalPrice() {
        BigDecimal productPrice = product.getPrice();

        return productPrice.multiply(new BigDecimal(quantity));
    }
}
