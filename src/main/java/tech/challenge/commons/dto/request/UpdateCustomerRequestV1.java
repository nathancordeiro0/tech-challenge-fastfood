package tech.challenge.commons.dto.request;

import jakarta.validation.constraints.Email;
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
public class UpdateCustomerRequestV1 {
    @NotBlank(message = "The field 'id' cannot be null")
    private UUID id;

    @NotBlank(message = "The field 'name' is required")
    private String name;

    @NotBlank(message = "The field 'email' is required")
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,10}$", message = "The e-mail is not valid")
    private String email;

    @NotBlank(message = "The field 'cpf' is required")
    private String cpf;
}
