package com.gomarket.GoMarket.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Characteristic")
@Getter
@Setter
@NoArgsConstructor
public class Characteristic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "characteristic")
    private Set<ProductCharacteristic> productCharacteristics = new HashSet<>();

    public Characteristic(String name) {
        this.name = name;
    }

    public Characteristic(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
