package org.example.jounralproject.service;

import org.bson.types.ObjectId;
import org.example.jounralproject.model.User;
import org.example.jounralproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    public Optional<User> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }
}
