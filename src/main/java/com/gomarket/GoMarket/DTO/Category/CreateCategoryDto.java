package com.gomarket.GoMarket.DTO;


import com.gomarket.GoMarket.Model.Characteristic;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateCategoryDto {
    private String name;
    private List<Characteristic> characteristics
}
