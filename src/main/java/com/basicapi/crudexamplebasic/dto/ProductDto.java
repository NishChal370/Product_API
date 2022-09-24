package com.basicapi.crudexamplebasic.dto;

import lombok.Data;
import lombok.Builder;
import javax.persistence.Id;

@Data
@Builder
public class ProductDto {

    @Id
    private int id;
    private String name;
    private int quantity;
    private double price;
}
