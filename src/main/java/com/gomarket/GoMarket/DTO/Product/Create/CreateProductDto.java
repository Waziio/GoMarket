package com.gomarket.GoMarket.DTO.Product.Create;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateProductDto {
    private String title;
    private String description;
    private Double price;
    private Long categoryId;
    private List<ProductCharacteristicDto> characteristics;
}