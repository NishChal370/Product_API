package com.basicapi.crudexamplebasic.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.basicapi.crudexamplebasic.model.Product;
import com.basicapi.crudexamplebasic.dto.ProductDto;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    List<ProductDto> toDto(List<Product> products);

    Product toEntity(ProductDto productDto);

    List<Product> toEntity(List<ProductDto> productsDto);
}