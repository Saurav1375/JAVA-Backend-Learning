package org.example.springjpaandh2.repository;

import org.example.springjpaandh2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


@RestController
public interface ProductRepository  extends JpaRepository<Product, Integer> {
}
