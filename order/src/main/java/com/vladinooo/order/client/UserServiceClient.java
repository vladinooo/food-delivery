package com.vladinooo.order.client;

import com.vladinooo.order.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserServiceClient {

  @GetMapping("/user/find-by-id/{id}")
  ResponseEntity<UserDto> findUserById(@PathVariable Integer id);

}
