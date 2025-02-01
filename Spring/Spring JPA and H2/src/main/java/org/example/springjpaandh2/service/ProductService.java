package org.example.springjpaandh2.service;

import org.example.springjpaandh2.model.Product;
import org.example.springjpaandh2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repo;
    public List<Product> getAllProducts() {
        return repo.findAll();

    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product());
    }

    public void addProduct(Product product){
        repo.save(product);
    }

    public void updateProduct(Product product){
        repo.save(product);
    }

    public void deleteProduct(int id){
        repo.deleteById(id);
    }

}
