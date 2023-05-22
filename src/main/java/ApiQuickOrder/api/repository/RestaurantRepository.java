package ApiQuickOrder.api.repository;

import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query("SELECT r FROM Restaurant r WHERE r.name like ?1 ")
    List<Restaurant> search(String search);

    @Query(value = "SELECT * FROM restaurant r ORDER BY RAND() limit ?1", nativeQuery = true)
    List<Restaurant> rand(int limit);

    @Query(value = "SELECT * FROM restaurant r  ORDER BY r.rating DESC limit ?1 ", nativeQuery = true)
    List<Restaurant> populars(int limit);
}
