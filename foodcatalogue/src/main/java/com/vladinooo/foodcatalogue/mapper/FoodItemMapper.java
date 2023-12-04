package com.vladinooo.foodcatalogue.mapper;

import com.vladinooo.foodcatalogue.dto.FoodItemDto;
import com.vladinooo.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItemDto);

    FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);

}

