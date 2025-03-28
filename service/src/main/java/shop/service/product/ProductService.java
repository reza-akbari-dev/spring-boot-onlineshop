package shop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.entity.product.Product;
import shop.dataaccess.repository.product.ColorRepository;
import shop.dataaccess.repository.product.ProductCategoryRepository;
import shop.dataaccess.repository.product.ProductRepository;
import shop.dataaccess.repository.product.SizeRepository;
import shop.dto.product.ProductCategoryDto;
import shop.dto.product.ProductDto;
import shop.enums.ProductQueryType;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ColorRepository colorRepository;
    private final SizeRepository sizeRepository;
    private final ProductCategoryRepository categoryRepository;
    private final ModelMapper mapper;


    @Autowired
    public ProductService(ProductRepository repository,
                          ColorRepository colorRepository,
                          SizeRepository sizeRepository,
                          ProductCategoryRepository categoryRepository, ModelMapper mapper) {
        this.repository = repository;
        this.colorRepository = colorRepository;
        this.sizeRepository = sizeRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public List<ProductCategoryDto> readAllCategory() {
        return categoryRepository.findAllByEnableIsTrue().
                stream().map(x -> mapper
                        .map(x, ProductCategoryDto.class)).toList();
    }

    public List<ProductDto> read6TopProducts(ProductQueryType type) {
        List<Product> result = new ArrayList<>();
        switch (type) {
            case Popular -> {
                result=repository.find6PopularProducts();
            }
            case Newest -> {
                result = repository.find6NewestProducts();
            }
            case Cheapest -> {
                result = repository.ind6CheapestProducts();
            }
            case Expensive -> {
                result = repository.find6ExpensiveProducts();
            }
        }
        return result.stream().map(x -> mapper.map(x, ProductDto.class)).toList();
    }
}
