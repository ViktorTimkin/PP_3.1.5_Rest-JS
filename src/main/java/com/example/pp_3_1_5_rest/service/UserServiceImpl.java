package com.example.pp_3_1_5_rest.service;

import com.example.pp_3_1_5_rest.models.User;
import com.example.pp_3_1_5_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        user.setPassword(user.getPassword());
        userRepository.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Transactional
    @Override
    public void editUser(Long id, User user) {
        user.setId(id);
        user.setPassword(user.getPassword());
        userRepository.editUser(id, user);
    }

    @Override
    public User getUserById(Long id) {
        User oneUser = userRepository.getUserById(id);
        if (id == null) {
            throw new RuntimeException("Пользователь не найден");
        }
        return oneUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    //=========================================================================================
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.isEmpty())
            throw new UsernameNotFoundException("Пользователь не найден");
        return userRepository.getUserByUsername(username);
    }
}