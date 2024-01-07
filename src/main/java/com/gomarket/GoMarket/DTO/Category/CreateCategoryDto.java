package com.gomarket.GoMarket.DTO.Category;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateCategoryDto {
    private String name;
    private List<CharacteristicDto> characteristics;
}
