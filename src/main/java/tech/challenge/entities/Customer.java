package tech.challenge.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Customer {
    private UUID id;
    private String name;
    private String email;
    private String cpf;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
