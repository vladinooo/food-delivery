package com.vladinooo.restaurantlisting.service;

import com.vladinooo.restaurantlisting.dto.RestaurantDto;
import com.vladinooo.restaurantlisting.entity.Restaurant;
import com.vladinooo.restaurantlisting.mapper.RestaurantMapper;
import com.vladinooo.restaurantlisting.repository.RestaurantRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepo restaurantRepo;

    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        return restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant)).toList();
    }

    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        Restaurant savedRestaurant = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(savedRestaurant);
    }

    public Optional<RestaurantDto> findRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if (!restaurant.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant.get()));
    }

}
