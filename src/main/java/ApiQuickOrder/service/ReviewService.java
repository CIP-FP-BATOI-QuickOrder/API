package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.ReviewRepository;
import ApiQuickOrder.models.Review;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

   public List<Review> getByRestaurantId(int restaurantId){
        return repository.getByRestaurantId(restaurantId);
    }

    public Review save(Review review){
       return repository.save(review);
    }
}
