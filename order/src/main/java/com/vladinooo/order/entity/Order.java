package com.vladinooo.order.entity;

import com.vladinooo.order.dto.FoodItemDto;
import com.vladinooo.order.dto.RestaurantDto;
import com.vladinooo.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

    private Integer id;
    private List<FoodItemDto> foodItems;
    private RestaurantDto restaurant;
    private UserDto user;

}
