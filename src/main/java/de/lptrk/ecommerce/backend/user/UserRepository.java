package de.lptrk.ecommerce.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEty, Integer> {
    Optional<UserEty> findByEmail(String email);
}

