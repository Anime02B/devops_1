package com.watchwise.watchwise.services;

import com.watchwise.watchwise.dto.ActorCharacter;
import com.watchwise.watchwise.entities.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Boolean updateRole(Role role);
    Boolean deleteRole(Long id);
    public List<ActorCharacter> findRolesByMovieIdWithActors(Long movieId);
}
