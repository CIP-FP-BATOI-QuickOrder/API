package ApiQuickOrder.api.repository;

import ApiQuickOrder.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
