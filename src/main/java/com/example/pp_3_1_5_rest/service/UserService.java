package com.example.pp_3_1_5_rest.service;

import com.example.pp_3_1_5_rest.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);

    void deleteUser(Long id);

    void editUser(Long id, User user);

    User getUserById(Long id);

    List<User> getAllUsers();

}