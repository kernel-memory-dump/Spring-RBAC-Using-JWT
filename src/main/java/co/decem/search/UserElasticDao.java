package co.decem.search;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import co.decem.model.User;

public interface UserElasticDao extends ElasticsearchRepository<User, Long> { 
    User findByUsername(String username);
    List<User> findByUsernameOrEmailOrName(String username, String email, String name);
    
    @Query("{\"bool\": {\"should\": [" +
    "{\"match_phrase_prefix\": {\"name\": \"?0\"}}," +
    "{\"match_phrase_prefix\": {\"username\": \"?0\"}}," +
    "{\"match_phrase_prefix\": {\"email\": \"?0\"}}" +
    "]}}")
    List<User> searchUsers(String searchText);
}
