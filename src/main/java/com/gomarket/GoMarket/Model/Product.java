package com.gomarket.GoMarket.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<ProductCharacteristic> characteristics = new HashSet<>();

    public Product(String title, String description, Double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
