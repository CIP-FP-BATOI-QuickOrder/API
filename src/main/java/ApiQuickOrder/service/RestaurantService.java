package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.RestaurantRepository;
import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
public class RestaurantService {
    @Autowired
    private RestaurantRepository repository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Restaurant> findAll(){
        updateRatings();
        return repository.findAll();
    }

    public List<Restaurant> search(String search){
        updateRatings();
        search = '%' + search + "%";
        return repository.search(search);
    }

    public List<Restaurant> rand(int limit){
        updateRatings();
        return repository.rand(limit);
    }

    public List<Restaurant> populars(int limit){
        updateRatings();
        return repository.populars(limit);
    }

    private void updateRatings() {
        String sql = "UPDATE restaurant r SET r.rating = COALESCE((SELECT AVG(rt.rating) FROM ratings rt WHERE rt.restaurant_id = r.id), 0);";
        jdbcTemplate.update(sql);
    }

    public List<Restaurant> getFavorites(int userId){
        return repository.getFavorites(userId);
    }
    public Restaurant getById(int restaurantId){
        return repository.getById(restaurantId);
    }

    public Restaurant save(Restaurant restaurant){
        return repository.save(restaurant);
    }

    public void updatePhoto(int restaurantId, String photoName) {
        String sql = "Update restaurant set photo = '" + photoName + "' where id = " + restaurantId + ";";
        jdbcTemplate.update(sql);
    }
    public Optional<Restaurant> login(String nif, String password){
        Restaurant restaurant = repository.login(nif, password);
        if (restaurant != null) {
            return Optional.of(restaurant);
        }
        throw new NoSuchElementException();
    }

    public Restaurant getByNif(String nif){
        return repository.getByNif(nif);
    }
}
