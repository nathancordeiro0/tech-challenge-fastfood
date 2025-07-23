package tech.challenge.usecases.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.challenge.commons.interfaces.gateways.CustomerGatewayInterface;
import tech.challenge.entities.Customer;

@Service
@RequiredArgsConstructor
public class GetCustomerByCpfUseCase {

    private final CustomerGatewayInterface customerGatewayInterface;

    public Customer execute(String cpf) {
        return customerGatewayInterface.findByCpf(cpf);
    }
}
