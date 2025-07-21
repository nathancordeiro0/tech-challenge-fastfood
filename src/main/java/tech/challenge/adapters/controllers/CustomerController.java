package tech.challenge.adapters.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.challenge.adapters.presenters.CustomerMapper;
import tech.challenge.commons.dto.request.CreateCustomerRequestV1;
import tech.challenge.commons.dto.response.CustomerResponseV1;
import tech.challenge.usecases.customer.CreateCustomerUseCase;
import tech.challenge.usecases.customer.GetCustomerByCpfUseCase;
import tech.challenge.usecases.customer.GetCustomerByIdUseCase;

import java.util.UUID;

@RestController
@RequestMapping("api/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final GetCustomerByIdUseCase getCustomerById;
    private final GetCustomerByCpfUseCase getCustomerByCpf;
    private final CreateCustomerUseCase createCustomer;
    private final CustomerMapper mapper;

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponseV1> findById(@PathVariable UUID id) {
        log.debug("findById: '{}'", id);

        var customer = getCustomerById.execute(id);

        var response = mapper.toCustomerResponseV1(customer);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("auth/{cpf}")
    public ResponseEntity<CustomerResponseV1> auth(@PathVariable String cpf) {
        log.debug("auth: '{}'", cpf);

        var customer = getCustomerByCpf.execute(cpf);

        var response = mapper.toCustomerResponseV1(customer);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<CustomerResponseV1> save(@RequestBody CreateCustomerRequestV1 request) {
        log.debug("save: '{}'", request);

        var newCustomer = mapper.fromRequestToEntity(request);

        var savedCustomer = createCustomer.execute(newCustomer);

        var response = mapper.toCustomerResponseV1(savedCustomer);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
