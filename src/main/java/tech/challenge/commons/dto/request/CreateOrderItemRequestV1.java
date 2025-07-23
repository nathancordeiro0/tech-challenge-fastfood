package tech.challenge.commons.dto.request;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "The field 'quantity' is required")
    private Integer quantity;

    @NotBlank(message = "The field 'productId' cannot be null")
    private UUID productId;
}
