package com.example.pp_3_1_5_rest.service;

import com.example.pp_3_1_5_rest.models.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(Long id);

    void addRole(Role role);

    List<Role> getAllRoles();
}