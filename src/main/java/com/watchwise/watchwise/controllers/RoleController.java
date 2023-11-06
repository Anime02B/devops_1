package com.watchwise.watchwise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.watchwise.watchwise.entities.Role; // Импортируйте Role
import com.watchwise.watchwise.services.RoleService; // Импортируйте RoleService

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public Role addRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRole(@RequestBody Role role) {
        Boolean updated = roleService.updateRole(role);
        if (updated) {
            return ResponseEntity.ok("Role updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        Boolean deleted = roleService.deleteRole(id);
        if (deleted) {
            return ResponseEntity.ok("Role deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

