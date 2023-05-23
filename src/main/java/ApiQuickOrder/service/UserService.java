package ApiQuickOrder.service;

import ApiQuickOrder.api.repository.UserRepository;
import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<User> findById(Integer id){
        return repository.findById(id);
    }

    public Optional<User> login(String email, String password){
        User user = repository.login(email, password);
        if (user != null) {
            return Optional.of(user);
        }
        throw new NoSuchElementException();
    }

    public User save(User user){
        try {
            user = repository.save(user);
        }catch (Exception e){
            throw new NoSuchElementException();
        }
        return user;
    }

    public User findByEmail(String email){
        return repository.findByEmail(email);
    }

    public Boolean isFavorite(int userId, int restaurantId){
        return repository.isFavorite(userId, restaurantId) > 0;
    }

    public void addFavorites(int userId, int restaurantId) {
        String sql = "INSERT INTO favorites (user_id, restaurant_id) VALUES (" + userId + ", " + restaurantId + ");";
        jdbcTemplate.update(sql);
    }

    public void removeFavorites(int userId, int restaurantId) {
        String sql = "DELETE FROM favorites where user_id =" + userId + " and restaurant_id =" + restaurantId + " ;";
        jdbcTemplate.update(sql);
    }

}
