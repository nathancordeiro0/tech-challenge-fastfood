package tech.challenge.adapters.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.challenge.adapters.presenters.ProductMapper;
import tech.challenge.commons.exception.NotFoundException;
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
    public List<Product> listAll() {
        return productDataSource.findAll()
                .stream()
                .map(mapper::fromDaoToEntity)
                .toList();
    }

    public Product findByIdOrThrowNotFound(UUID id) {
        return mapper.fromDaoToEntity(productDataSource.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not Found")));
    }

    @Override
    public Product save(Product entity) {
        var newProduct = mapper.toDAO(entity);

        return mapper.fromDaoToEntity(productDataSource.save(newProduct));
    }

    @Override
    public void delete(UUID id) {
        var productToDelete = findByIdOrThrowNotFound(id);

        productDataSource.delete(mapper.toDAO(productToDelete));
    }

    @Override
    public void update(Product entity) {
        findByIdOrThrowNotFound(entity.getId());

        productDataSource.save(mapper.toDAO(entity));
    }
}
