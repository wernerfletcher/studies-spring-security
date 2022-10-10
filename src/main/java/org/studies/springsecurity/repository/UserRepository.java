package org.studies.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.studies.springsecurity.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
