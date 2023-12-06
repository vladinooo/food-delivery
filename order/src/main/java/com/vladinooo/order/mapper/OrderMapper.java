package com.vladinooo.order.mapper;

import com.vladinooo.order.dto.SavedOrderDto;
import com.vladinooo.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    SavedOrderDto mapOrderToSavedOrderDto(Order order);


}

