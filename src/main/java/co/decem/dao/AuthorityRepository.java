package co.decem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.decem.model.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(String name);
}
