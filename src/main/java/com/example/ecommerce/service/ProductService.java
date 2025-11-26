package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Product create(Product p) {
        return repository.save(p);
    }

    public Product update(String id, Product updated) {

    Product existing = repository.findById(id).orElse(null);

    if (existing == null) {
        return null;
    }

    existing.setName(updated.getName());
    existing.setDescription(updated.getDescription());
    existing.setPrice(updated.getPrice());
    existing.setImage(updated.getImage());
    existing.setCategory(updated.getCategory());
    existing.setStock(updated.getStock());

    return repository.save(existing);
}


    public boolean delete(String id) {
    if (!repository.existsById(id)) {
        return false;
    }
    repository.deleteById(id);
    return true;
}

}
