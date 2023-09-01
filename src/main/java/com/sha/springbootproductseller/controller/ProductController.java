package com.sha.springbootproductseller.controller;

import com.sha.springbootproductseller.model.Product;
import com.sha.springbootproductseller.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
            return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getALlProducts(){
        return new ResponseEntity<>(productService.findAllProducts(),HttpStatus.OK);
    }


}
