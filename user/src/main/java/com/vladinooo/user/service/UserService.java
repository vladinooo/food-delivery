package com.vladinooo.user.service;

import com.vladinooo.user.dto.UserDto;
import com.vladinooo.user.entity.User;
import com.vladinooo.user.mapper.UserMapper;
import com.vladinooo.user.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public UserDto addUser(UserDto userDto) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDtoToUser(userDto));
        return UserMapper.INSTANCE.mapUserToUserDto(savedUser);
    }

    public Optional<UserDto> findUserById(Integer id) {
        Optional<User> user = userRepo.findById(id);
        if (!user.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(UserMapper.INSTANCE.mapUserToUserDto(user.get()));
    }

}
