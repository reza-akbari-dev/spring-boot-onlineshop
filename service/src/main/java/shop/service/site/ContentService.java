package shop.service.site;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.common.exceptions.NotFoundException;
import shop.dataaccess.entity.site.Content;
import shop.dataaccess.repository.site.ContentRepository;
import shop.dto.site.ContentDto;

import java.util.List;

@Service
public class ContentService {
    private final ContentRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public ContentService(ContentRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<ContentDto> readAll() {
        return repository.findAll().stream()
                .map(x -> mapper.map(x, ContentDto.class)).toList();
    }
    public ContentDto readByKey(String key) throws NotFoundException {
        Content content = repository.findFirstByKeyNameEqualsIgnoreCase(key)
                .orElseThrow(NotFoundException::new);

return mapper.map(content, ContentDto.class);
    }
}
