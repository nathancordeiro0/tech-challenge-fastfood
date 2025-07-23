package tech.challenge.usecases.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.challenge.commons.interfaces.gateways.ProductGatewayInterface;
import tech.challenge.entities.Product;

@Service
@RequiredArgsConstructor
public class UpdateProductUseCase {

    private final ProductGatewayInterface productGatewayInterface;

    public void execute(Product entity) {
        productGatewayInterface.update(entity);
    }
}
