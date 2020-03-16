package com.finartz.ticket.service;

import com.finartz.ticket.exception.FinartzNotFoundException;
import com.finartz.ticket.exception.InvalidException;
import com.finartz.ticket.model.User;
import com.finartz.ticket.model.UserId;
import com.finartz.ticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by promegalex on 11.03.2020 18:37
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> get(UserId userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new FinartzNotFoundException("User Cannot be found");
        }
        return userRepository.findById(userId);
    }

    public User save(User user) {
        UserId userId = user.getId();
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            throw new InvalidException("User Cannot be found");
        }
        return userRepository.save(user);
    }

    public User update(User user) {
        UserId userId = user.getId();
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new FinartzNotFoundException("User Cannot be found");
        }
        return userRepository.save(user);
    }

    public void delete(UserId userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new FinartzNotFoundException("User Cannot be found");
        }
        userRepository.deleteById(userId);
    }
}
