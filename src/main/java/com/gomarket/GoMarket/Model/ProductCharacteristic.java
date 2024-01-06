package com.gomarket.GoMarket.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ProductCharacteristic")
@Getter
@Setter
@NoArgsConstructor
public class ProductCharacteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "characteristic_id")
    private Characteristic characteristic;

    public ProductCharacteristic(Characteristic characteristic, String value, Product product) {
        this.name = characteristic.getName();
        this.value = value;
        this.product = product;
        this.characteristic = characteristic;
    }
}
