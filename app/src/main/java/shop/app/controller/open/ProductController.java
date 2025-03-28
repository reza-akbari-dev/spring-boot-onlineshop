package shop.app.controller.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.app.model.APIResponse;
import shop.app.model.enums.APIStatus;
import shop.dto.product.ProductCategoryDto;
import shop.dto.product.ProductDto;
import shop.enums.ProductQueryType;
import shop.service.product.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("category")
    public APIResponse<List<ProductCategoryDto>> getAll() {
        return APIResponse.<List<ProductCategoryDto>>builder()
                .status(APIStatus.Success)
                .data(service.readAllCategory())
                .build();
    }

    @GetMapping("type/{type}")
    public APIResponse<List<ProductDto>> getTopProducts(@PathVariable ProductQueryType type) {
        return APIResponse.<List<ProductDto>>builder()
                .status(APIStatus.Success)
                .data(service.read6TopProducts(type))
                .build();
    }
}
