package tech.challenge.commons.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.challenge.commons.enums.ProductCategory;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
public class CreateProductRequestV1 {
    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategory category;
    private String imagePath;
}
