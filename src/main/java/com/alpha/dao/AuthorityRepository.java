package com.alpha.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.model.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(String name);
}
