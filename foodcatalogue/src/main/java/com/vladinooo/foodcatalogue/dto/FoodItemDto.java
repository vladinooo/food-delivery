package com.vladinooo.foodcatalogue.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDto {

    private int id;
    private String name;
    private String description;
    private boolean isVegetarian;
    private Number price;
    private Integer restaurantId;
    private Integer quantity;

}
