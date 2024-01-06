package com.gomarket.GoMarket.Service;

import com.gomarket.GoMarket.Model.Product;
import com.gomarket.GoMarket.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        return productRepository.findById(id)
                .map(p -> {
                    p.setTitle(product.getTitle());
                    p.setDescription(product.getDescription());
                    p.setPrice(product.getPrice());
                    return productRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Product " + id + " has been deleted";
    }
}
