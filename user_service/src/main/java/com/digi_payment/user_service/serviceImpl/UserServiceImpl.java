package com.digi_payment.user_service.serviceImpl;

import com.digi_payment.user_service.Entity.User;
import com.digi_payment.user_service.repository.UserRepository;
import com.digi_payment.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user)
    {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
