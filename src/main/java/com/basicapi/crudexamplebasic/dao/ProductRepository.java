package com.basicapi.crudexamplebasic.dao;

import com.basicapi.crudexamplebasic.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);
}
