package shop.app.controller.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.app.model.APIResponse;
import shop.app.model.enums.APIStatus;
import shop.dto.site.NavDto;
import shop.service.site.NavService;

import java.util.List;

@RestController
@RequestMapping("/api/nav")
public class NavController {

    private final NavService service;

    @Autowired
    public NavController(NavService service) {
        this.service = service;
    }

    @GetMapping("")
    public APIResponse <List<NavDto>>getAll () {
    return APIResponse.<List<NavDto>>builder()
            .status(APIStatus.Success)
            .data(service.readAll())
            .build();
}
}
