package tech.challenge.adapters.presenters.helpers;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import tech.challenge.commons.interfaces.gateways.ProductGatewayInterface;
import tech.challenge.entities.Product;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductMapperHelper {

    private final ProductGatewayInterface productGatewayInterface;

    @Named("ProductIdMapper")
    public Product map(UUID id) {
        return productGatewayInterface.findById(id);
    }
}
