package tech.challenge.entities;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private UUID id;
    private String name;
    private String email;
    private String cpf;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
