package ApiQuickOrder.api.repository;

import ApiQuickOrder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = ?1 and u.password = ?2")
    User login(String email, String password);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}
