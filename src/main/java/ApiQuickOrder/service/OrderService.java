package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.OrderRepository;
import ApiQuickOrder.models.Order;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order getById(int id){
        return repository.getById(id);
    }

    public Order save(Order order) {
        return repository.save(order);
    }
}
