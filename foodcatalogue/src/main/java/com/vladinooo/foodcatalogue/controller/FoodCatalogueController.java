package com.vladinooo.foodcatalogue.controller;

import com.vladinooo.foodcatalogue.dto.FoodCataloguePageDto;
import com.vladinooo.foodcatalogue.dto.FoodItemDto;
import com.vladinooo.foodcatalogue.service.FoodCatalogueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food-catalogue")
@AllArgsConstructor
public class FoodCatalogueController {

    private final FoodCatalogueService foodCatalogueService;

    @PostMapping("/add-food-item")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto) {
        FoodItemDto foodItemAdded = foodCatalogueService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(foodItemAdded, HttpStatus.CREATED);
    }

    @GetMapping("/get-restaurant-with-menu/{restaurantId}")
    public ResponseEntity<FoodCataloguePageDto> getRestaurantWithMenu(@PathVariable Integer restaurantId) {
        FoodCataloguePageDto foodCataloguePageDto = foodCatalogueService.getFoodCataloguePageDetails(restaurantId);
        return new ResponseEntity<>(foodCataloguePageDto, HttpStatus.OK);
    }


}
