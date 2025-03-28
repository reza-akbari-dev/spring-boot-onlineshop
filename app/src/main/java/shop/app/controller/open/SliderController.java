package shop.app.controller.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.app.model.APIResponse;
import shop.app.model.enums.APIStatus;
import shop.dto.site.SliderDto;
import shop.service.site.SliderService;

import java.util.List;

@RestController
@RequestMapping("/api/slider")
public class SliderController {
    private final SliderService service;
    @Autowired
    public SliderController(SliderService service) {
        this.service = service;
    }
   @GetMapping("")
    public APIResponse<List<SliderDto>> getAll (){
    return APIResponse.<List<SliderDto>>builder()
            .status(APIStatus.Success)
            .data(service.readAll())
            .build();
    }
}
