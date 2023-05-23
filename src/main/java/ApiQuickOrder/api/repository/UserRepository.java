package ApiQuickOrder.api.repository;

import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = ?1 and u.password = ?2")
    User login(String email, String password);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

    @Query(value = "SELECT COUNT(*) > 0 FROM favorites f WHERE f.user_id = ?1 AND f.restaurant_id = ?2", nativeQuery = true)
    Long isFavorite(int userId, int restaurantId);

}
