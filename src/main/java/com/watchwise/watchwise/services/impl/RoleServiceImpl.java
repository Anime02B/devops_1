package com.watchwise.watchwise.services.impl;

import com.watchwise.watchwise.dto.ActorCharacter;
import com.watchwise.watchwise.entities.Role;
import com.watchwise.watchwise.repositories.RoleRepository;
import com.watchwise.watchwise.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean updateRole(Role role) {
        Role existingRole = roleRepository.findById(role.getId()).orElse(null);
        if (existingRole != null) {
            roleRepository.save(role);
            System.out.println("OK updateRole");
            return true;
        } else {
            System.out.println("Error updateRole");
            return false;
        }
    }

    @Override
    public Boolean deleteRole(Long id) {
        Role existingRole = roleRepository.findById(id).orElse(null);
        if (existingRole != null) {
            roleRepository.deleteById(id);
            System.out.println("OK deleteRole");
            return true;
        } else {
            System.out.println("Error deleteRole");
            return false;
        }
    }

    @Override
    public List<ActorCharacter> findRolesByMovieIdWithActors(Long movieId) {
        return roleRepository.findActorsAndCharactersByMovieId(movieId);
    }


}
