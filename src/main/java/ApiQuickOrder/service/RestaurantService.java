package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.RestaurantRepository;
import ApiQuickOrder.models.Restaurant;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class RestaurantService {
    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> findAll(){
        return repository.findAll();
    }

    public List<Restaurant> search(String search){
        search = '%' + search + "%";
        return repository.search(search);
    }
}
