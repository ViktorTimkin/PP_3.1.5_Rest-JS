package com.example.pp_3_1_5_rest.repository;


import com.example.pp_3_1_5_rest.models.Role;

import java.util.List;

public interface RoleRepository {
    Role getRoleById(Long id);

    Role getRoleByName(String name);

    List<Role> getAllRoles();

    void addRole(Role role);
}