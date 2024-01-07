package com.gomarket.GoMarket.Repository;

import com.gomarket.GoMarket.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
