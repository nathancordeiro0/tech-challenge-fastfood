package tech.challenge.commons.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class CreateOrderItemRequestV1 {
    private Integer quantity;
    private UUID productId;
}
