package com.gomarket.GoMarket.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "ProductCharacteristic")
@Getter
@Setter
@NoArgsConstructor
@Data
public class ProductCharacteristic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private String value;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonIgnore
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
