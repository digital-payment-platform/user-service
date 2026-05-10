package com.digi_payment.user_service.service;

import com.digi_payment.user_service.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
      public  User createUser(User user);

      public  User getUserById(Long id);

      public void deleteUserById(Long id);

      public List<User> getAllUsers();
}
