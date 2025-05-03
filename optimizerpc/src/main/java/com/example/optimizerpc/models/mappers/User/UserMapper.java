package com.example.optimizerpc.models.mappers.User;

import com.example.optimizerpc.models.dtos.User.UserDTO;
import com.example.optimizerpc.models.entities.User.User;
import org.modelmapper.ModelMapper;

public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO mapDTO(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }
}
