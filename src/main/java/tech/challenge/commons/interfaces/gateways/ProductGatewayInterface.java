package tech.challenge.commons.interfaces.gateways;

import tech.challenge.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductGatewayInterface {
    List<Product> findAll();
    Product findById(UUID id);
    Product findByOrderItemId(UUID id);
    Product save(Product entity);
    void delete(UUID id);
    void update(Product entity);
}
