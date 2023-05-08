package ApiQuickOrder.api.repository;

import ApiQuickOrder.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

}
