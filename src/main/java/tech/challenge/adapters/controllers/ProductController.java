package tech.challenge.adapters.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.challenge.adapters.presenters.ProductMapper;
import tech.challenge.commons.dto.request.CreateProductRequestV1;
import tech.challenge.commons.dto.request.UpdateProductRequestV1;
import tech.challenge.commons.dto.response.ProductResponseV1;
import tech.challenge.commons.enums.ProductCategory;
import tech.challenge.usecases.product.CreateProductUserCase;
import tech.challenge.usecases.product.DeleteProductByIdUseCase;
import tech.challenge.usecases.product.ListProductsUseCase;
import tech.challenge.usecases.product.UpdateProductUseCase;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ListProductsUseCase listProducts;
    private final CreateProductUserCase createProduct;
    private final DeleteProductByIdUseCase deleteProductById;
    private final UpdateProductUseCase updateProduct;
    private final ProductMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductResponseV1>> listAll(@RequestParam ProductCategory category) {
        var productsList = listProducts.execute()
                .stream()
                .filter(cat -> cat.getCategory().equals(category))
                .map(mapper::toProductResponseV1)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }

    @PostMapping
    public ResponseEntity<ProductResponseV1> save(@RequestBody @Valid CreateProductRequestV1 request) {
        log.debug("save request: '{}'", request);

        var newProduct = mapper.fromRequestToEntity(request);

        var savedProduct = createProduct.execute(newProduct);

        var response = mapper.toProductResponseV1(savedProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        log.debug("delete request: '{}'", id);

        deleteProductById.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateProductRequestV1 request) {
        log.debug("update request: '{}'", request);

        var newProduct = mapper.fromRequestToEntity(request);

        updateProduct.execute(newProduct);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}