package com.vladinooo.foodcatalogue.service;

import com.vladinooo.foodcatalogue.dto.FoodCataloguePageDto;
import com.vladinooo.foodcatalogue.dto.FoodItemDto;
import com.vladinooo.foodcatalogue.dto.RestaurantDto;
import com.vladinooo.foodcatalogue.entity.FoodItem;
import com.vladinooo.foodcatalogue.mapper.FoodItemMapper;
import com.vladinooo.foodcatalogue.repository.FoodItemRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class FoodCatalogueService {

    private final FoodItemRepo foodItemRepo;
    private final RestTemplate restTemplate;

    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem savedFoodItem = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDto));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(savedFoodItem);
    }

    public FoodCataloguePageDto getFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItemDto> foodItemDtos = getFoodItems(restaurantId);
        RestaurantDto restaurantDto = getRestaurant(restaurantId);
        return createFoodCataloguePage(foodItemDtos, restaurantDto);
    }

    private List<FoodItemDto> getFoodItems(Integer restaurantId) {
        List<FoodItem> foodItems = foodItemRepo.findByRestaurantId(restaurantId);
        return foodItems.stream().map(foodItem -> FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItem)).toList();
    }

    private RestaurantDto getRestaurant(Integer restaurantId) {
        return restTemplate.getForObject("http://restaurant-service/restaurant/find-by-id/" + restaurantId, RestaurantDto.class);
    }

    private FoodCataloguePageDto createFoodCataloguePage(List<FoodItemDto> foodItemDtos, RestaurantDto restaurantDto) {
        FoodCataloguePageDto foodCataloguePageDto = new FoodCataloguePageDto();
        foodCataloguePageDto.setFoodItems(foodItemDtos);
        foodCataloguePageDto.setRestaurant(restaurantDto);
        return foodCataloguePageDto;
    }
}
