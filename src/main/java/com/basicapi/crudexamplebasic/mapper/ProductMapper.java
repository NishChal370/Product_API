package com.basicapi.crudexamplebasic.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.basicapi.crudexamplebasic.model.Product;
import com.basicapi.crudexamplebasic.dto.ProductDto;

@Component
public class ProductMapper {

    public Product toEntity(ProductDto productDto){

        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();
    }

    public List<Product> toEntity(List<ProductDto> productsDto){

        return productsDto.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public ProductDto toDto(Product product){

        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();

    }

    public List<ProductDto> toDto(List<Product> products){

        return products.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
