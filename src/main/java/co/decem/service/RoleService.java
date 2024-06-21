package co.decem.service;

import co.decem.model.Role;

// Declaring the RoleService interface
public interface RoleService {
    // Method to find a Role by its name
    Role findByName(String name);
}
