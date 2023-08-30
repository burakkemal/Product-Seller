package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.Product;
import com.sha.springbootproductseller.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product){
        return this.productRepository.save(product);
    }
    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
}