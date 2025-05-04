package com.example.optimizerpc.models.adapters.User;

import com.example.optimizerpc.models.dtos.User.UserCreateDTO;
import com.example.optimizerpc.models.entities.User.User;
import com.example.optimizerpc.models.mappers.User.UserMapper;
import com.example.optimizerpc.models.services.User.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserAdapter {

    private final IUserService userService;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserAdapter(IUserService userService, UserMapper mapper, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(UserCreateDTO request) {

        User user = User.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .firstLastName(request.getFirstLastName())
                .secondLastName(request.getSecondLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .username(request.getUsername())
                .build();

        return userService.save(user);
    }

}
