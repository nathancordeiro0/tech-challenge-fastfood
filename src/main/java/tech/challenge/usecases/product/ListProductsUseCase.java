package tech.challenge.usecases.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.challenge.commons.interfaces.gateways.ProductGatewayInterface;
import tech.challenge.entities.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListProductsUseCase {

    private final ProductGatewayInterface productGatewayInterface;

    public List<Product> execute() {
        return productGatewayInterface.listAll();
    }
}
