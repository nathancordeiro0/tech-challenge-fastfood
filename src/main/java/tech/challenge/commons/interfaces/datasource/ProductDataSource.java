package tech.challenge.commons.interfaces.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.challenge.commons.dao.ProductDAO;

import java.util.UUID;

@Repository
public interface ProductDataSource extends JpaRepository<ProductDAO, UUID> {
}
