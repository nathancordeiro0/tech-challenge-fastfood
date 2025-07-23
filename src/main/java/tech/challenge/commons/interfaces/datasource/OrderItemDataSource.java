package tech.challenge.commons.interfaces.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.challenge.commons.dao.OrderItemDAO;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderItemDataSource extends JpaRepository<OrderItemDAO, UUID> {

    List<OrderItemDAO> findAllByOrderId(UUID id);
}
