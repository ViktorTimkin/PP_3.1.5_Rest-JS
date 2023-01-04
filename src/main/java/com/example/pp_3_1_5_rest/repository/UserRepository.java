package com.example.pp_3_1_5_rest.repository;

import com.example.pp_3_1_5_rest.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository {
    void addUser(User user);

    void deleteUser(Long id);

    void editUser(Long id,User user); //id ?

    User getUserById(Long id);

    List<User> getAllUsers();

    UserDetails getUserByUsername(String username);

}