package com.gomarket.GoMarket.Service;

import com.gomarket.GoMarket.DTO.CharacteristicRequest;
import com.gomarket.GoMarket.DTO.CreateProductRequest;
import com.gomarket.GoMarket.Exception.NotFoundException;
import com.gomarket.GoMarket.Model.Characteristic;
import com.gomarket.GoMarket.Model.Product;
import com.gomarket.GoMarket.Model.ProductCharacteristic;
import com.gomarket.GoMarket.Repository.CharacteristicRepository;
import com.gomarket.GoMarket.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CharacteristicRepository characteristicRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public Product create(CreateProductRequest productRequest) {
        Product product = new Product(productRequest.getTitle(), productRequest.getDescription(), productRequest.getPrice());

        // Add ProductCharacteristics to product
        for (CharacteristicRequest characteristicReq : productRequest.getCharacteristics()) {
            Characteristic characteristic = characteristicRepository.findById(characteristicReq.getCharacteristicId()).orElseThrow(() -> new NotFoundException("Characteristic not found"));
            ProductCharacteristic productCharacteristic = new ProductCharacteristic(characteristic, characteristicReq.getValue(), product);
            product.getCharacteristics().add(productCharacteristic);
        }
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        return productRepository.findById(id)
                .map(p -> {
                    p.setTitle(product.getTitle());
                    p.setDescription(product.getDescription());
                    p.setPrice(product.getPrice());
                    return productRepository.save(p);
                }).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Product " + id + " has been deleted";
    }
}
