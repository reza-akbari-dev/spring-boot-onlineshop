package shop.service.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.repository.site.NavRepository;

@Service
public class NavService {
private final NavRepository repository;

    @Autowired
    public NavService(NavRepository repository) {
        this.repository = repository;
    }
}
