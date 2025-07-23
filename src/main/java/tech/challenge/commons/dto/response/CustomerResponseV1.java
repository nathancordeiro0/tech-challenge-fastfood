package tech.challenge.commons.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class CustomerResponseV1 {
    private UUID id;
    private String name;
    private String email;
    private String cpf;
}
