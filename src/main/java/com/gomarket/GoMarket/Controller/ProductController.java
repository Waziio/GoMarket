package com.gomarket.GoMarket.Controller;


import com.gomarket.GoMarket.DTO.Product.Create.CreateProductDto;
import com.gomarket.GoMarket.DTO.Product.Response.ProductResponseDto;
import com.gomarket.GoMarket.Model.Product;
import com.gomarket.GoMarket.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
@Validated
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping("")
    public ProductResponseDto create(@RequestBody CreateProductDto product) {
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}
