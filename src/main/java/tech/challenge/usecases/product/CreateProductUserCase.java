package tech.challenge.usecases.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.challenge.commons.interfaces.gateways.ProductGatewayInterface;
import tech.challenge.entities.Product;

@Service
@RequiredArgsConstructor
public class CreateProductUserCase {

    private final ProductGatewayInterface customerGatewayInterface;

    public Product execute(Product entity) {
        return customerGatewayInterface.save(entity);
    }
}
