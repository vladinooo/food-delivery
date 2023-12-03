package com.vladinooo.user.mapper;

import com.vladinooo.user.dto.UserDto;
import com.vladinooo.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDtoToUser(UserDto userDto);

    UserDto mapUserToUserDto(User user);

}

