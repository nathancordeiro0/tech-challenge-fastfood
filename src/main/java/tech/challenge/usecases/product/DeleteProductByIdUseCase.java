package tech.challenge.usecases.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.challenge.commons.interfaces.gateways.ProductGatewayInterface;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteProductByIdUseCase {

    private final ProductGatewayInterface productGatewayInterface;

    public void execute(UUID id) {
        productGatewayInterface.delete(id);
    }
}
