package shop.service.site;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.repository.site.NavRepository;
import shop.dto.site.NavDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NavService {
private final NavRepository repository;
private final ModelMapper mapper;

    @Autowired
    public NavService(NavRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<NavDto> readAll() {
        return repository.findAllByEnableIsTrueOrderByOrderNumberAsc()
                .stream().map(x -> mapper.map(x, NavDto.class)).toList();
    }
}
