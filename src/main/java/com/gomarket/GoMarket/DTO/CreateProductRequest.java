package com.gomarket.GoMarket.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateProductRequest {
    private String title;
    private String description;
    private Double price;
    private Long categoryId;
    private List<CharacteristicRequest> characteristics;
}