package com.example.optimizerpc.models.repository.User;

import com.example.optimizerpc.models.entities.User.User;
import com.example.optimizerpc.models.repository.BaseEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseEntityRepository<User, String> {

    Optional<User> findByUsername(String username);

}
