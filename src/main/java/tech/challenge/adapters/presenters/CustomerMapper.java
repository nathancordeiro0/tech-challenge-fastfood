package tech.challenge.adapters.presenters;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import tech.challenge.commons.dao.CustomerDAO;
import tech.challenge.commons.dto.request.CreateCustomerRequestV1;
import tech.challenge.commons.dto.response.CustomerResponseV1;
import tech.challenge.entities.Customer;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    CustomerDAO toDAO(Customer entity);

    Customer fromDaoToEntity(CustomerDAO dao);

    CustomerResponseV1 toCustomerResponseV1(Customer entity);

    Customer fromRequestToEntity(CreateCustomerRequestV1 requestV1);

}
