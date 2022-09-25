package com.basicapi.crudexamplebasic.service;

import java.util.List;
import java.text.MessageFormat;
import com.basicapi.crudexamplebasic.model.Product;
import com.basicapi.crudexamplebasic.dao.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveOrUpdate(Product product){

        return productRepository.save(product);
    }

    public List<Product> saveAll(List<Product> products){
        productRepository.saveAll(products);

        return getAll();
    }

    public List<Product> getAll(){

        return productRepository.findAll();
    }

    public Product get(Integer id){

        return productRepository.findById(id).orElse(null);
    }

    public Product get(String name){

        return productRepository.findByName(name);
    }

    public String delete(Integer id){
        productRepository.deleteById(id);

        return MessageFormat.format("Product with id {0} is deleted.", id);
    }

    public String deleteAll(){
        productRepository.deleteAll();

        return "All Products has been deleted.";
    }
}
