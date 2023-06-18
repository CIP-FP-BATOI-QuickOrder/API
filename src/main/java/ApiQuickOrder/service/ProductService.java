package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.ProductRepository;
import ApiQuickOrder.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Product getById(int id){
        return repository.getById(id);
    }

    public List<Product> findByRestaurant(int restaurantId){
        return repository.findByRestaurant(restaurantId);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public Product save(Product product){
        return repository.save(product);
    }

    public void updatePhoto(int productId, String photoName) {
        String sql = "Update product set photo = '" + photoName + "' where id = " + productId + ";";
        jdbcTemplate.update(sql);
    }
}
