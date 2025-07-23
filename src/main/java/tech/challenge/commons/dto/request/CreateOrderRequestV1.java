package tech.challenge.commons.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class CreateOrderRequestV1 {
    private UUID customerId;

    @NotNull(message = "The field 'orderItems' cannot be null")
    private List<CreateOrderItemRequestV1> orderItems;
}
