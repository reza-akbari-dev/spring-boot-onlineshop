package shop.app.controller.open;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.app.model.APIResponse;
import shop.app.model.enums.APIStatus;
import shop.common.exceptions.NotFoundException;
import shop.dto.site.ContentDto;
import shop.service.site.ContentService;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    final private ContentService service;

    public ContentController(ContentService service) {
        this.service = service;
    }

    @GetMapping("")
    public APIResponse<List<ContentDto>> getAll() {
        return APIResponse.<List<ContentDto>>builder()
                .status(APIStatus.Success)
                .data(service.readAll())
                .build();
    }

    @GetMapping("{key}")
    public APIResponse<ContentDto> getByKey(@PathVariable String key) {
        try {
            return APIResponse.<ContentDto>builder()
                    .status(APIStatus.Success)
                    .data(service.readByKey(key))
                    .build();
        } catch (NotFoundException e) {
            return APIResponse.<ContentDto>builder()
                    .status(APIStatus.Error)
                    .message(e.getMessage())
                    .build();
        }
    }
}
