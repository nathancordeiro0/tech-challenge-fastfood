package tech.challenge.commons.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.challenge.commons.enums.ProductCategory;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class ProductResponseV1 {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategory category;
    private String imagePath;
}
