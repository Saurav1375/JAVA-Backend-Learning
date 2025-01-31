package org.example.myapplication.service;

import org.example.myapplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "OnePlus Nord 2", "Mobile Phone", 20000.0),
            new Product(2, "Iphone 16", "Mobile Phone", 200000.0),
            new Product(3, "Hp Omen 16", "Gaming Laptop", 100000.0)
    ));

    public List<Product> getAllProducts() {
        return products;

    }

    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(new Product(0, "No item", "", 0));
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void updateProduct(Product product){
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                index = i;
            }
        }
        products.set(index, product);
    }

    public void deleteProduct(int id){
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                break;
            }
        }
    }

}
