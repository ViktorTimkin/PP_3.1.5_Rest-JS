package com.example.pp_3_1_5_rest.Initialization;

import com.example.pp_3_1_5_rest.models.Role;
import com.example.pp_3_1_5_rest.models.User;
import com.example.pp_3_1_5_rest.service.RoleService;
import com.example.pp_3_1_5_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public ApplicationRunnerImpl(UserService userService,
                                 RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            roleService.addRole(new Role("ROLE_ADMIN"));
            roleService.addRole(new Role("ROLE_USER"));
            Role admin = roleService.getRoleById(1L);
            Role user = roleService.getRoleById(2L);
            Set<Role> adminRole = new HashSet<>();
            Set<Role> userRole = new HashSet<>();
            adminRole.add(admin);
            userRole.add(user);
            userService.addUser(new User("admin", ("admin"), adminRole));
            userService.addUser(new User("user", ("user"), userRole));
        }
    }
}
