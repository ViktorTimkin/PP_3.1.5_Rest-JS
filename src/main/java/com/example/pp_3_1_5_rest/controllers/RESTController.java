package com.example.pp_3_1_5_rest.controllers;

import com.example.pp_3_1_5_rest.models.User;
import com.example.pp_3_1_5_rest.service.RoleServiceImpl;
import com.example.pp_3_1_5_rest.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    public UserServiceImpl userService;
    public RoleServiceImpl roleService;
    public BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RESTController(UserServiceImpl userService,
                          RoleServiceImpl roleService,
                          BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getOneUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> userUpdate(@PathVariable Long id,@RequestBody User user) {
        userService.editUser(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


/*    @GetMapping("/user/userAdmin")
    public ResponseEntity<User> showCurrentUser(@AuthenticationPrincipal User user) { //@AuthenticationPrincipal
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/

}
