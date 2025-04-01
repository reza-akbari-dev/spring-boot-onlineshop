package shop.app.controller.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.app.model.APIResponse;
import shop.app.model.enums.APIStatus;
import shop.common.exceptions.NotFoundException;
import shop.dto.site.BlogDto;
import shop.dto.site.SingleBlogDto;
import shop.service.site.BlogService;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class BlogController {
    private final BlogService service;

    @Autowired
    public BlogController(BlogService service) {
        this.service = service;
    }
    @GetMapping("")
    public APIResponse getAll(@RequestParam(required = false) Integer page,
                              @RequestParam(required = false) Integer size) {
        return APIResponse.<List<BlogDto>>builder()
                .status(APIStatus.Success)
                .data(service.readAll(page, size))
                .build();
    }

   public APIResponse <SingleBlogDto> getByKey(@PathVariable Long id) {
       try {
           return APIResponse.<SingleBlogDto>builder()
                   .status(APIStatus.Success)
                   .data(service.read(id))
                   .build();
       } catch (NotFoundException e) {
           return APIResponse.<SingleBlogDto>builder()
                   .status(APIStatus.Error)
                   .message(e.getMessage())
                   .build();
       }
   }
}
