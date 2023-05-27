package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.ProductRepository;
import ApiQuickOrder.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repository;


    public List<Product> findByRestaurant(int restaurantId){
        return repository.findByRestaurant(restaurantId);
    }
}
