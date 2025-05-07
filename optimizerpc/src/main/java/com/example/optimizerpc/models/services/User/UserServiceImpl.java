package com.example.optimizerpc.models.services.User;

import com.example.optimizerpc.exceptions.ResourceNotFoundException;
import com.example.optimizerpc.models.entities.User.User;
import com.example.optimizerpc.models.repository.User.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User clazz) {
        return repository.save(clazz);
    }

    @Override
    public List<User> save(List<User> clazz) {
        return repository.saveAll(clazz);
    }

    @Override
    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The user", "id",
                id));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(Specification<User> specification) {
        return repository.findAll(specification);
    }

    @Override
    public Page<User> findAll(Specification<User> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

    @Override
    public void delete(User clazz) {
        repository.delete(clazz);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

}
