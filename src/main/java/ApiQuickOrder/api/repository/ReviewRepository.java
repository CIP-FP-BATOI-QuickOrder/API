package ApiQuickOrder.api.repository;

import ApiQuickOrder.models.Review;
import ApiQuickOrder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("SELECT r FROM Review r WHERE r.restaurant.id = ?1")
    List<Review> getByRestaurantId(int restaurantId);

}
