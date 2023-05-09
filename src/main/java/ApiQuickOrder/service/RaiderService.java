package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.RaiderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RaiderService {
    @Autowired
    private RaiderRepository repository;


}
