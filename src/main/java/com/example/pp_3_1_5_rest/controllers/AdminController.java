package com.example.pp_3_1_5_rest.controllers;

import com.example.pp_3_1_5_rest.models.User;
import com.example.pp_3_1_5_rest.service.RoleServiceImpl;
import com.example.pp_3_1_5_rest.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String allUsers(Model model, Principal principal) {
        model.addAttribute("userAdmin", userService.loadUserByUsername(principal.getName()));
        List<User> user = userService.getAllUsers();
        model.addAttribute("newUser", new User());
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin";
    }



/*    @PostMapping("/add")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam("role") String role) {
        if(role.equals("ROLE_USER")) {
            user.setRoles(Set.of(roleService.getRoleById(2L)));
        } else if(role.equals("ROLE_ADMIN")) {
            user.setRoles(Set.of(roleService.getRoleById(1L)));
        }
        userService.addUser(user);
        return "redirect:/admin"; // /admin_panel
    }

    @PatchMapping("/edit/{id}")
    public String userUpdate(@ModelAttribute("user") User user, @RequestParam("role") String role) {

        if(role.equals("ROLE_USER")) {
            user.setRoles(Set.of(roleService.getRoleById(2L)));
        } else if(role.equals("ROLE_ADMIN")) {
            user.setRoles(Set.of(roleService.getRoleById(1L)));
        }
        userService.editUser(user);
        return "redirect:/admin"; // /admin_panel
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";//  /admin_panel
    }*/
}