package tech.challenge.commons.interfaces.gateways;

import tech.challenge.entities.Customer;

import java.util.UUID;

public interface CustomerGatewayInterface {
    Customer findByIdOrThrowNotFound(UUID id);
    Customer findByCpfOrThrowNotFound(String cpf);
    Customer save(Customer entity);
}
