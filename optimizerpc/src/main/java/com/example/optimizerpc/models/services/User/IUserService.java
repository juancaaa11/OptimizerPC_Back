package com.example.optimizerpc.models.services.User;

import com.example.optimizerpc.models.entities.User.User;
import com.example.optimizerpc.models.services.BaseEntityService;

import java.util.Optional;

public interface IUserService extends BaseEntityService<User> {

    Optional<User> findByUsername(String username);
}
