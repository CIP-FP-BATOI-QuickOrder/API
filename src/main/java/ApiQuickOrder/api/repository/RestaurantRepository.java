package ApiQuickOrder.api.repository;

import ApiQuickOrder.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
