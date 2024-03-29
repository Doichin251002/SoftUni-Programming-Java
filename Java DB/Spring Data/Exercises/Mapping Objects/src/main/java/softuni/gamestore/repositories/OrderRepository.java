package softuni.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.gamestore.domain.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
