package com.example.pp_3_1_5_rest.service;

import com.example.pp_3_1_5_rest.models.Role;
import com.example.pp_3_1_5_rest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }
    @Transactional
    @Override
    public void addRole(Role role) {
        roleRepository.addRole(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }
}