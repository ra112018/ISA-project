package com.example.projectIsa.users.mapper;

import com.example.projectIsa.users.dto.UserDTO;
import com.example.projectIsa.users.model.User;

public class UserMapper {

	public UserMapper() {}

    public static UserDTO MapToDTO(User u){
        UserDTO dto = new UserDTO(u.getId(),u.getName(),u.getSurname(),u.getEmail(),u.getPassword(),
                u.getPhoneNumber(),u.getAddress(),u.getDeleted(),u.getRole());
        return dto;
    }
}
