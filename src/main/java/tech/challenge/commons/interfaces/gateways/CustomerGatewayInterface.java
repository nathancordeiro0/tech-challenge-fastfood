package tech.challenge.commons.interfaces.gateways;

import tech.challenge.entities.Customer;

import java.util.UUID;

public interface CustomerGatewayInterface {
    Customer findById(UUID id);

    Customer findByCpf(String cpf);

    Customer save(Customer entity);
}
