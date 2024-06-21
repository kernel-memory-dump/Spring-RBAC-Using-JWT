package co.decem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.decem.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{

        Role findByName(String name);
}
