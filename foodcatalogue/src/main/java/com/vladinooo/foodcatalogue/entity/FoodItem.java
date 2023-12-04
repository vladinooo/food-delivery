package com.vladinooo.foodcatalogue.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private boolean isVegetarian;
    private Number price;
    private Integer restaurantId;
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0 ")
    private Integer quantity;

}
