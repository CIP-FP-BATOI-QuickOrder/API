package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.RestaurantRepository;
import ApiQuickOrder.models.Restaurant;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


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

    private void updateRatings() {
        String sql = "UPDATE restaurant r SET r.rating = ( SELECT AVG(rt.rating) FROM ratings rt WHERE rt.restaurant_id = r.id)";
        jdbcTemplate.update(sql);
    }
}
