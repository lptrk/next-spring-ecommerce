package de.lptrk.ecommerce.backend.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEty, String> {
}
