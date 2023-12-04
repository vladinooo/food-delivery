package com.vladinooo.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePageDto {

    private List<FoodItemDto> foodItems;
    private RestaurantDto restaurant;

}
