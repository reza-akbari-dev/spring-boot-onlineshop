package shop.service.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.repository.site.ContentRepository;

@Service
public class ContentService {
    private final ContentRepository repository;

    @Autowired
    public ContentService(ContentRepository repository) {
        this.repository = repository;
    }
}
