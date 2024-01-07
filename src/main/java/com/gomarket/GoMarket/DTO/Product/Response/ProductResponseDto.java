package com.gomarket.GoMarket.DTO.Product.Response;

import com.gomarket.GoMarket.Model.ProductCharacteristic;
import lombok.Data;

import java.util.Set;

@Data
public class ProductResponseDto {
    private Long productId;
    private String title;
    private String description;
    private Double price;
    private Long categoryId;
    private Set<ProductCharacteristic> characteristics;


    public ProductResponseDto(Long productId, String title, String description, Double price, Long categoryId, Set<ProductCharacteristic> characteristics) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.characteristics = characteristics;
    }
}
