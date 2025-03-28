package shop.service.site;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.repository.site.SliderRepository;
import shop.dto.site.SliderDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SliderService {
private final SliderRepository repository;
private final ModelMapper mapper;

@Autowired
    public SliderService(SliderRepository repository, ModelMapper mapper) {
        this.repository = repository;

    this.mapper = mapper;
}

    public List<SliderDto> readAll() {
    return repository.findAllByEnableIsTrueOrderByOrderNumberAsc().stream()
            .map(x->mapper.map(x, SliderDto.class)).toList();

    }
}

