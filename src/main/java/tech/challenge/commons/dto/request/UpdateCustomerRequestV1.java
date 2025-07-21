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
public class UpdateCustomerRequestV1 {
    private UUID id;
    private String name;
    private String email;
    private String cpf;
}
