package ApiQuickOrder.service;

import ApiQuickOrder.api.repository.UserRepository;
import ApiQuickOrder.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;

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
}
