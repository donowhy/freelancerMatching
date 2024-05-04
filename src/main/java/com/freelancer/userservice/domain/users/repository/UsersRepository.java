package com.freelancer.userservice.domain.users.repository;


import com.freelancer.userservice.domain.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUsersByEmail(String email);
}
