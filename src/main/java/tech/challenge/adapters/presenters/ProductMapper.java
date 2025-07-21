package tech.challenge.adapters.presenters;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import tech.challenge.commons.dao.ProductDAO;
import tech.challenge.commons.dto.request.CreateProductRequestV1;
import tech.challenge.commons.dto.request.UpdateProductRequestV1;
import tech.challenge.commons.dto.response.ProductResponseV1;
import tech.challenge.entities.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    ProductDAO toDAO(Product entity);

    Product fromDaoToEntity(ProductDAO dao);

    ProductResponseV1 toProductResponseV1(Product entity);

    Product fromRequestToEntity(CreateProductRequestV1 requestV1);

    Product fromRequestToEntity(UpdateProductRequestV1 requestV1);

}
