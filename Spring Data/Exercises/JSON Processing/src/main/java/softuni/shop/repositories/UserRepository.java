package softuni.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.shop.domain.entities.Category;
import softuni.shop.domain.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from products_shop.users order by rand() limit 1"
            , nativeQuery = true)
    Optional<User> getRandomEntity();
    List<User> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName();
}
