package com.vladinooo.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private List<FoodItemDto> foodItems;
    private Integer userId;
    private RestaurantDto restaurant;

}
