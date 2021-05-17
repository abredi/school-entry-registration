package com.reziz.studentregistration.auth.repositories;

import java.util.Optional;

import com.reziz.studentregistration.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String userName);
}
