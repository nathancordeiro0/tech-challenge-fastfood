package tech.challenge.commons.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CreateCustomerRequestV1 {
    private String name;
    private String email;
    private String cpf;
}
