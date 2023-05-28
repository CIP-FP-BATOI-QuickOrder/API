package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.PaymentMethodRepository;
import ApiQuickOrder.models.Address;
import ApiQuickOrder.models.PaymentMethod;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentMethodService {
    @Autowired
    private PaymentMethodRepository repository;

    public PaymentMethod save(PaymentMethod paymentMethod){
        return repository.save(paymentMethod);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public PaymentMethod getById(int id){
        return repository.getById(id);
    }

}
