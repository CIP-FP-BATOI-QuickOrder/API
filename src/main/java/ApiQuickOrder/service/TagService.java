package ApiQuickOrder.service;


import ApiQuickOrder.api.repository.RestaurantRepository;
import ApiQuickOrder.api.repository.TagsRepository;
import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.models.Tags;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class TagService {
    @Autowired
    private TagsRepository repository;

    public Tags save(Tags tag){
        return repository.save(tag);
    }
}
