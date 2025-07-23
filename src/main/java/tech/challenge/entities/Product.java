package tech.challenge.entities;

import lombok.*;
import tech.challenge.commons.enums.ProductCategory;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategory category;
    private String imagePath;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
