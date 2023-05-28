package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.AddressRepository;
import ApiQuickOrder.models.Address;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public Address save(Address address){
        return repository.save(address);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public Address getById(int id){
        return repository.getById(id);
    }
}
