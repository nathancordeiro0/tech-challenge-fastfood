package tech.challenge.commons.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AuthCustomerRequestV1 {
    @NotBlank(message = "The field 'cpf' is required")
    private String cpf;
}
