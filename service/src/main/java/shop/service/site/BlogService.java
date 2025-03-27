package shop.service.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.repository.site.BlogRepository;

@Service
public class BlogService {
    private final BlogRepository repository;
@Autowired
    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }
}
