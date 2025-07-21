package tech.challenge.adapters.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.challenge.adapters.presenters.CustomerMapper;
import tech.challenge.commons.exception.NotFoundException;
import tech.challenge.commons.interfaces.datasource.CustomerDataSource;
import tech.challenge.commons.interfaces.gateways.CustomerGatewayInterface;
import tech.challenge.entities.Customer;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerGateway implements CustomerGatewayInterface {

    private final CustomerDataSource customerDataSource;
    private final CustomerMapper mapper;

    @Override
    public Customer findByIdOrThrowNotFound(UUID id) {
        return mapper.fromDaoToEntity(customerDataSource.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not Found")));
    }

    @Override
    public Customer findByCpfOrThrowNotFound(String cpf) {
        return mapper.fromDaoToEntity(customerDataSource.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Customer not Found")));
    }

    @Override
    public Customer save(Customer entity) {
        var request = mapper.toDAO(entity);

        return mapper.fromDaoToEntity(customerDataSource.save(request));
    }
}
