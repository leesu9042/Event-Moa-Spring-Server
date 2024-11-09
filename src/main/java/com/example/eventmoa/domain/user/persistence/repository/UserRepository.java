package com.example.eventmoa.domain.user.persistence.repository;

import com.example.eventmoa.domain.user.persistence.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
