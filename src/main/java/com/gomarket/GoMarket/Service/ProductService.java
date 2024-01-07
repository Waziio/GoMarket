package com.gomarket.GoMarket.Service;

import com.gomarket.GoMarket.DTO.Product.Create.ProductCharacteristicDto;
import com.gomarket.GoMarket.DTO.Product.Create.CreateProductDto;
import com.gomarket.GoMarket.DTO.Product.Response.ProductResponseDto;
import com.gomarket.GoMarket.Exception.NotFoundException;
import com.gomarket.GoMarket.Model.Category;
import com.gomarket.GoMarket.Model.Characteristic;
import com.gomarket.GoMarket.Model.Product;
import com.gomarket.GoMarket.Model.ProductCharacteristic;
import com.gomarket.GoMarket.Repository.CategoryRepository;
import com.gomarket.GoMarket.Repository.CharacteristicRepository;
import com.gomarket.GoMarket.Repository.ProductCharacteristicRepository;
import com.gomarket.GoMarket.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CharacteristicRepository characteristicRepository;
    private final ProductCharacteristicRepository productCharacteristicRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public ProductResponseDto create(CreateProductDto productRequest) {
        Product product = new Product(productRequest.getTitle(), productRequest.getDescription(), productRequest.getPrice());

//        Add its category
        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new NotFoundException("Category not exists"));
        product.setCategory(category);
//
//        Add its characteristics
        product.setCharacteristics(new HashSet<ProductCharacteristic>());
        for (ProductCharacteristicDto characteristicReq : productRequest.getCharacteristics()) {
            Characteristic characteristic = characteristicRepository.findById(characteristicReq.getCharacteristicId()).orElseThrow(() -> new NotFoundException("Characteristic not found"));
            ProductCharacteristic productCharacteristic = new ProductCharacteristic(characteristic, characteristicReq.getValue(), product);
            product.getCharacteristics().add(productCharacteristic);
        }
        Product savedProduct = productRepository.save(product);

        for (ProductCharacteristic productCharacteristic : product.getCharacteristics()) {
            productCharacteristic.setProduct(product);
            productCharacteristicRepository.save(productCharacteristic);
        }

        return new ProductResponseDto(
                savedProduct.getId(),
                savedProduct.getTitle(),
                savedProduct.getDescription(),
                savedProduct.getPrice(),
                savedProduct.getCategory().getId(),
                savedProduct.getCharacteristics()
        );
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
