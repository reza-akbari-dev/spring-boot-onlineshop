package shop.service.site;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shop.common.exceptions.NotFoundException;
import shop.dataaccess.entity.site.Blog;
import shop.dataaccess.repository.site.BlogRepository;
import shop.dto.site.BlogDto;
import shop.dto.site.SingleBlogDto;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public BlogService(BlogRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<BlogDto> readAll(Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 20;
        }
        return repository.findAllByPublished(Pageable.ofSize(size).withPage(page))
                .stream().map(x -> mapper.map(x, BlogDto.class)).toList();
    }

    public SingleBlogDto read(Long id) throws NotFoundException {
        Blog blog = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.map(blog, SingleBlogDto.class);
    }

}
