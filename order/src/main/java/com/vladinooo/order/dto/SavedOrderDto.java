package com.vladinooo.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavedOrderDto {

    private Integer id;
    private List<FoodItemDto> foodItems;
    private RestaurantDto restaurant;
    private UserDto user;

}
