package com.alpha.dao;

import com.alpha.model.User;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long>, ElasticsearchRepository<User, Long> { //da li ovde treba da extenduje oba?
    User findByUsername(String username);
}