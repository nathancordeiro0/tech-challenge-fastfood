package tech.challenge.adapters.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.challenge.adapters.presenters.OrderMapper;
import tech.challenge.commons.dto.request.CreateOrderRequestV1;
import tech.challenge.commons.dto.response.OrderResponseV1;
import tech.challenge.usecases.order.CreateOrderUseCase;
import tech.challenge.usecases.order.ListOrderUseCase;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final ListOrderUseCase listOrder;
    private final CreateOrderUseCase createOrder;
    private final OrderMapper mapper;

    @GetMapping
    public ResponseEntity<List<OrderResponseV1>> listAll() {
        var orders = listOrder.execute();

        var response = orders.stream().map(mapper::toOrderResponseV1).toList();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<OrderResponseV1> save(@RequestBody CreateOrderRequestV1 request) {
        log.debug("save: '{}'", request);

        var newOrder = mapper.fromRequestToEntity(request);

        var savedOrder = createOrder.execute(newOrder);

        var response = mapper.toOrderResponseV1(savedOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
