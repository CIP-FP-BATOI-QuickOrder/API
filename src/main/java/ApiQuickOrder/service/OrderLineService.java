package ApiQuickOrder.service;

import ApiQuickOrder.api.repository.OrderLineRepository;
import ApiQuickOrder.models.OrderLine;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderLineService {
    @Autowired
    private OrderLineRepository repository;

    public OrderLine save(OrderLine line){
        return repository.save(line);
    }

}
