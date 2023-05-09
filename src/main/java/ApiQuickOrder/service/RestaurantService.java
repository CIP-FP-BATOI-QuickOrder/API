package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RestaurantService {
    @Autowired
    private RestaurantRepository repository;


}
