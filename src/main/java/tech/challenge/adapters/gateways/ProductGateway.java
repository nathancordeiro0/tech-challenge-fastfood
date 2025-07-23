package tech.challenge.adapters.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.challenge.adapters.presenters.ProductMapper;
import tech.challenge.commons.interfaces.datasource.ProductDataSource;
import tech.challenge.commons.interfaces.gateways.ProductGatewayInterface;
import tech.challenge.entities.Product;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductGateway implements ProductGatewayInterface {

    private final ProductDataSource productDataSource;
    private final ProductMapper mapper;

    @Override
    public List<Product> findAll() {
        return productDataSource.findAll()
                .stream()
                .map(mapper::fromDaoToEntity)
                .toList();
    }

    @Override
    public Product findById(UUID id) {
        return mapper.fromDaoToEntity(productDataSource.findById(id)
                .orElse(null));
    }

    @Override
    public Product findByOrderItemId(UUID id) {
        return mapper.fromDaoToEntity(productDataSource.findByOrderItemId(id)
                .orElse(null));
    }

    @Override
    public Product save(Product entity) {
        var newProduct = mapper.toDAO(entity);

        return mapper.fromDaoToEntity(productDataSource.save(newProduct));
    }

    @Override
    public void delete(UUID id) {
        var productToDelete = findById(id);

        productDataSource.delete(mapper.toDAO(productToDelete));
    }

    @Override
    public void update(Product entity) {
        findById(entity.getId());

        productDataSource.save(mapper.toDAO(entity));
    }
}
