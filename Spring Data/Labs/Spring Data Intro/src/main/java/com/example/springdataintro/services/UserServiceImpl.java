package com.example.springdataintro.services;

import com.example.springdataintro.models.User;
import com.example.springdataintro.repositories.AccountRepository;
import com.example.springdataintro.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void register(User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());

        if (optionalUser.isPresent()) {
            throw new IllegalArgumentException("Username already taken");
        }

        userRepository.save(user);
    }
}
