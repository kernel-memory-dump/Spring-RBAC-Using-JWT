package com.alpha.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{

        Role findByName(String name);
}
