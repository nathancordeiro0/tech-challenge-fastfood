package tech.challenge.commons.dto.request;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "The field 'name' is required")
    private String name;

    @NotBlank(message = "The field 'description' is required")
    private String description;

    @NotBlank(message = "The field 'price' is required")
    private BigDecimal price;

    @NotBlank(message = "The field 'category' is required")
    private ProductCategory category;

    private String imagePath;
}
