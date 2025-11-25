package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Getter
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product("1", "Notebook Gamer",
                "Notebook potente para jogos",
                4500.0, "https://via.placeholder.com/150", "eletronicos", 10));

        products.add(new Product("2", "Camisa Preta",
                "Camisa básica confortável",
                79.90, "https://via.placeholder.com/150", "moda", 25));
    }

    public Product findById(String id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product create(Product product) {
        products.add(product);
        return product;
    }

    public Product update(String id, Product updated) {
        Product existing = findById(id);
        if (existing == null) return null;

        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setImage(updated.getImage());
        existing.setCategory(updated.getCategory());
        existing.setStock(updated.getStock());

        return existing;
    }

    public boolean delete(String id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}
