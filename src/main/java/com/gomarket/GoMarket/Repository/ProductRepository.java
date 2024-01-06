package com.gomarket.GoMarket.Repository;

import com.gomarket.GoMarket.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
