package ApiQuickOrder.service;

import ApiQuickOrder.api.repository.OrderLineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderLineService {
    @Autowired
    private OrderLineRepository repository;


}
