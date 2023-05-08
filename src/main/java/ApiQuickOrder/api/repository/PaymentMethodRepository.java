package ApiQuickOrder.api.repository;

import ApiQuickOrder.models.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

}
