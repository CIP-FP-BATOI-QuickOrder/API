package ApiQuickOrder.api.repository;

import ApiQuickOrder.models.Product;
import ApiQuickOrder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.restaurant.id = ?1")
    List<Product> findByRestaurant(int restaurantId);
}
