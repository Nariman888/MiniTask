package com.task1foralabs.Task1ForAlabs.mapper;

import com.task1foralabs.Task1ForAlabs.dto.UserDTO;
import com.task1foralabs.Task1ForAlabs.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toEntity(UserDTO userDTO);
    UserDTO toDto(Users user);
}
