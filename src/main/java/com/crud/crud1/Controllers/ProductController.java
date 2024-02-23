package com.crud.crud1.Controllers;

import com.crud.crud1.DOMAIN.Product.Product;
import com.crud.crud1.DOMAIN.Product.ProductRepository;
import com.crud.crud1.DOMAIN.Product.RequestProduct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product1")
public class ProductController {

    @Autowired
    private ProductRepository repository;
    @GetMapping
    public ResponseEntity getallproducts(){
        var allproducts=repository.findAllByActiveTrue();
        return ResponseEntity.ok(allproducts);
    }

    @PostMapping
    public ResponseEntity resistro(@RequestBody@Valid RequestProduct data){
        Product newproduct = new Product(data);
        repository.save(newproduct);
        return ResponseEntity.ok().build();

    }

    @PutMapping
    @Transactional
    public ResponseEntity updateproduct(@RequestBody@Valid RequestProduct data){
        Optional<Product> optionalProduct= repository.findById(data.id());
        if(optionalProduct.isPresent()){
            Product product= optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(product);

        }else{
            throw new EntityNotFoundException();

        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable String id){
        Optional<Product> optionalProduct= repository.findById(id);
        if(optionalProduct.isPresent()){
            Product product= optionalProduct.get();
            product.setActive(false);
            return ResponseEntity.noContent().build();

        }else{

            throw new EntityNotFoundException();

        }

    }


}
