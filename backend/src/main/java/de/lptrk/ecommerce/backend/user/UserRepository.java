package de.lptrk.ecommerce.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEty, Integer> {
}
