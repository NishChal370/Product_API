package com.basicapi.crudexamplebasic.model;

import lombok.Data;
import lombok.Builder;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.GeneratedValue;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Product") // this is optional, if we do not provide this, then class name will be the table name automatically
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double price;

}
