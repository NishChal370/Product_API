package com.basicapi.crudexamplebasic.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.basicapi.crudexamplebasic.model.Product;
import com.basicapi.crudexamplebasic.dto.ProductDto;
import com.basicapi.crudexamplebasic.mapper.ProductMapper;
import com.basicapi.crudexamplebasic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> saveOrUpdate(@RequestBody ProductDto productDto){
        Product product = mapper.toEntity(productDto);
        Product savedProduct = productService.saveOrUpdate(product);

        return new ResponseEntity<ProductDto>(mapper.toDto(savedProduct), HttpStatus.CREATED);
    }

    @PostMapping("/products")
    public ResponseEntity<List<ProductDto>> saveAll(@RequestBody List<ProductDto> productsDto){
        List<Product>  products = mapper.toEntity(productsDto);
        List<Product> savedProducts = productService.saveAll(products);

        return new ResponseEntity<List<ProductDto>>(mapper.toDto(savedProducts), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAll(){
        List<Product> products = productService.getAll();

        return new ResponseEntity<List<ProductDto>>(mapper.toDto(products), HttpStatus.FOUND);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Integer id){
        Product searchedProduct = productService.get(id);

        return new ResponseEntity<ProductDto>(mapper.toDto(searchedProduct), HttpStatus.FOUND);
    }

    @GetMapping("/product")
    public ResponseEntity<ProductDto> getByName(@RequestParam("name") String name){
        Product searchedProduct = productService.getByName(name);

        return new ResponseEntity<ProductDto>(mapper.toDto(searchedProduct), HttpStatus.FOUND);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){

        return new ResponseEntity<String>(productService.delete(id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/products")
    public ResponseEntity<String> deleteAll(){

        return new ResponseEntity<>(productService.deleteAll(), HttpStatus.ACCEPTED);
    }

}
