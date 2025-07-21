package tech.challenge.commons.interfaces.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.challenge.commons.dao.CustomerDAO;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerDataSource extends JpaRepository<CustomerDAO, UUID> {

    Optional<CustomerDAO> findByCpf(String cpf);
}
