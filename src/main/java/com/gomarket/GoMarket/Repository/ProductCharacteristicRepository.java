package com.gomarket.GoMarket.Repository;

import com.gomarket.GoMarket.Model.Characteristic;
import com.gomarket.GoMarket.Model.ProductCharacteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCharacteristicRepository extends JpaRepository<ProductCharacteristic, Long> {
}