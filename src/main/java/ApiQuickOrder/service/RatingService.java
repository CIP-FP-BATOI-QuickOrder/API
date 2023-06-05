package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.RaiderRepository;
import ApiQuickOrder.api.repository.RatingsRepository;
import ApiQuickOrder.models.Ratings;
import ApiQuickOrder.models.RatingsId;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RatingService {
    @Autowired
    private RatingsRepository repository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Ratings save(Ratings ratings){
        updatePhoto();
        return repository.save(ratings);
    }

    private void updatePhoto() {
        String sql = "UPDATE restaurant r SET r.rating = ( SELECT AVG(rt.rating) FROM ratings rt WHERE rt.restaurant_id = r.id);";
        jdbcTemplate.update(sql);
    }
}
