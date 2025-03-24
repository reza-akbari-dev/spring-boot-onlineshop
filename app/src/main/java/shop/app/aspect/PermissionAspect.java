package shop.app.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import shop.app.annotation.CheckPermission;
import shop.app.filter.JwtFilter;
import shop.app.model.APIResponse;
import shop.app.model.enums.APIStatus;
import shop.dto.user.PermissionDto;
import shop.dto.user.UserDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class PermissionAspect {
    private final HttpServletRequest request;


    @Autowired
    public PermissionAspect(HttpServletRequest request) {
        this.request = request;
    }

    @SneakyThrows
    @Around("@annotation(checkPermission)")
    public Object checkUserPermission(ProceedingJoinPoint joinPoint, CheckPermission checkPermission) {
        Object userObj = request.getAttribute(JwtFilter.CURRENT_USER);

        // Debugging Output
        if (userObj == null) {
            System.out.println("User object is null. JwtFilter.CURRENT_USER may not be set correctly.");
            return APIResponse.builder()
                    .message("Please Login First!")
                    .status(APIStatus.Forbidden)
                    .build();
        }

        System.out.println("User class type: " + userObj.getClass().getName());

        // Cast to UserDto
        UserDto user = (UserDto) userObj;

        List<String> permissions = user.getRoles().stream()
                .flatMap(x -> x.getPermissions().stream().map(PermissionDto::getName))
                .toList();

        if (!permissions.contains(checkPermission.value())) {
            return APIResponse.builder()
                    .status(APIStatus.Forbidden)
                    .message("Access Denied!")
                    .build();
        }

        return joinPoint.proceed();
    }

}

