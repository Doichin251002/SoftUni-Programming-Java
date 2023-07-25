package softuni.shop.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.shop.domain.entities.Category;
import softuni.shop.domain.models.CategorySummaryInfoModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select * from products_shop.categories order by rand() limit 1"
            , nativeQuery = true)
    Optional<Category> getRandomEntity();

    @Query(value = "select new softuni.shop.domain.models.CategorySummaryInfoModel" +
            "(c.name, count(p.id), avg(p.price), sum(p.price)) " +
            "from Product p join p.categories c group by c.id")
    List<CategorySummaryInfoModel> getAllCategories();
}
