package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.repository.product.ColorRepository;
import shop.dataaccess.repository.product.ProductCategoryRepository;
import shop.dataaccess.repository.product.ProductRepository;
import shop.dataaccess.repository.product.SizeRepository;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ColorRepository colorRepository;
    private final SizeRepository sizeRepository;
    private final ProductCategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository repository,
            ColorRepository colorRepository,
            SizeRepository sizeRepository,
            ProductCategoryRepository categoryRepository) {
        this.repository = repository;
        this.colorRepository = colorRepository;
        this.sizeRepository = sizeRepository;
        this.categoryRepository = categoryRepository;
    }
}
