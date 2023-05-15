package ApiQuickOrder.service;

import ApiQuickOrder.api.repository.UserRepository;
import ApiQuickOrder.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;

    public Optional<User> findById(Integer id){
        System.out.println("Dentro");
        return repository.findById(id);
    }

    public Optional<User> login(String email, String password){
        User user = repository.login(email, password);
        if (user != null) {
            return Optional.of(user);
        }
        throw new NoSuchElementException();
    }
}
