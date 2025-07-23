package tech.challenge.commons.interfaces.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.challenge.commons.dao.OrderDAO;

import java.util.UUID;

@Repository
public interface OrderDataSource extends JpaRepository<OrderDAO, UUID> {
}
