package tech.challenge.usecases.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.challenge.commons.interfaces.gateways.CustomerGatewayInterface;
import tech.challenge.entities.Customer;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCustomerByIdUseCase {

    private final CustomerGatewayInterface customerGatewayInterface;

    public Customer execute(UUID id) {
        return customerGatewayInterface.findByIdOrThrowNotFound(id);
    }
}
