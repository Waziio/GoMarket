package com.gomarket.GoMarket.Service;

import com.gomarket.GoMarket.DTO.Category.CharacteristicDto;
import com.gomarket.GoMarket.DTO.Category.CreateCategoryDto;
import com.gomarket.GoMarket.Exception.NotFoundException;
import com.gomarket.GoMarket.Model.Category;
import com.gomarket.GoMarket.Model.Characteristic;
import com.gomarket.GoMarket.Repository.CategoryRepository;
import com.gomarket.GoMarket.Repository.CharacteristicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CharacteristicRepository characteristicRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
    }

    public Category create(CreateCategoryDto categoryRequest) {
        Category category = new Category(categoryRequest.getName());

        for(CharacteristicDto characteristicReq : categoryRequest.getCharacteristics()) {
//            Characteristic characteristic = new Characteristic(characteristicReq.getName(), category.);
        }

        return category;
    }
}
