package com.basicapi.crudexamplebasic.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.basicapi.crudexamplebasic.model.Product;
import com.basicapi.crudexamplebasic.dto.ProductDto;
import com.basicapi.crudexamplebasic.mapper.ProductMapper;
import com.basicapi.crudexamplebasic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class ProductController {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ProductDto saveOrUpdate(@RequestBody ProductDto productDto){
        Product product = mapper.toEntity(productDto);
        Product savedProduct = productService.saveOrUpdate(product);

        return mapper.toDto(savedProduct);
    }

    @PostMapping("/products")
    public List<ProductDto> saveAll(@RequestBody List<ProductDto> productsDto){
        List<Product>  products = mapper.toEntity(productsDto);
        List<Product> savedProducts = productService.saveAll(products);

        return mapper.toDto(savedProducts);
    }

    @GetMapping("/products")
    public List<ProductDto> getAll(){
        List<Product> products = productService.getAll();

        return  mapper.toDto(products);
    }

    @GetMapping("/product/{id}")
    public ProductDto get(@PathVariable Integer id){
        Product searchedProduct = productService.get(id);

        return mapper.toDto(searchedProduct);
    }

    @GetMapping("/product")
    public ProductDto getByName(@RequestParam("name") String name){
        Product searchedProduct = productService.getByName(name);

        return mapper.toDto(searchedProduct);
    }

    @DeleteMapping("/product/{id}")
    public String delete(@PathVariable Integer id){

        return productService.delete(id);
    }

    @DeleteMapping("/products")
    public String deleteAll(){

        return productService.deleteAll();
    }

}
