package com.vladinooo.order.service;

import com.vladinooo.order.dto.OrderDto;
import com.vladinooo.order.dto.SavedOrderDto;
import com.vladinooo.order.dto.UserDto;
import com.vladinooo.order.entity.Order;
import com.vladinooo.order.mapper.OrderMapper;
import com.vladinooo.order.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final SequenceGenerator sequenceGenerator;
    private final RestTemplate restTemplate;

    public SavedOrderDto addOrder(OrderDto orderDto) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDto userDto = getUserById(orderDto.getUserId());
        Order order = new Order(newOrderId, orderDto.getFoodItems(), orderDto.getRestaurant(), userDto);
        orderRepo.save(order);
        return OrderMapper.INSTANCE.mapOrderToSavedOrderDto(order);
    }

    private UserDto getUserById(Integer userId) {
        return restTemplate.getForObject("http://user-service/user/find-by-id/" + userId, UserDto.class);
    }

}
