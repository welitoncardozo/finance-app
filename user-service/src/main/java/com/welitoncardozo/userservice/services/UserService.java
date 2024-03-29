package com.welitoncardozo.userservice.services;

import com.welitoncardozo.userservice.exceptions.BusinessException;
import com.welitoncardozo.userservice.models.User;
import com.welitoncardozo.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(final User user) {
        repository.findExistsOtherWithEmail(user.getId(), user.getEmail())
                .ifPresent(userValid -> {
                    throw new BusinessException("Email %s already in use.", userValid.getEmail());
                });

        repository.save(user.preSave());
    }

    public List<User.Dto> findAll() {
        return repository.findAll()
                .stream()
                .map(User.Dto::from)
                .toList();
    }

    public Optional<User> findByEmail(final String email) {
        return repository.findByEmail(email);
    }
}
