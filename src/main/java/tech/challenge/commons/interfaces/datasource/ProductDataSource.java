package tech.challenge.commons.interfaces.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.challenge.commons.dao.ProductDAO;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductDataSource extends JpaRepository<ProductDAO, UUID> {

    @Query(value = """
                SELECT p.*
                FROM tb_order_item oi
                JOIN tb_product p ON oi.product_id = p.id
                WHERE oi.id = :id
            """, nativeQuery = true)
    Optional<ProductDAO> findByOrderItemId(UUID id);
}
