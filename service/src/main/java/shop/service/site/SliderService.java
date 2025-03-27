package shop.service.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.repository.site.SliderRepository;

@Service
public class SliderService {
private final SliderRepository repository;

@Autowired
    public SliderService(SliderRepository repository) {
        this.repository = repository;
    }
}
