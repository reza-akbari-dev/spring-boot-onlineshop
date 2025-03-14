package shop.service.user;


import lombok.SneakyThrows;
import shop.common.exceptions.*;
import shop.common.exceptions.ValidationException;
import shop.common.utils.HashUtil;
import shop.dataaccess.entity.user.User;
import shop.dataaccess.repository.user.PermissionRepository;
import shop.dataaccess.repository.user.RoleRepository;
import shop.dataaccess.repository.user.UserRepository;
import shop.dto.user.LimitedUserDto;
import shop.dto.user.LoginDto;
import shop.dto.user.UserDto;
import shop.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final ModelMapper mapper;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PermissionRepository permissionRepository,
                       ModelMapper mapper, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.mapper = mapper;
        this.jwtUtil = jwtUtil;
    }

    public LimitedUserDto login(LoginDto dto) throws Exception {
        String password = HashUtil.sha1Hash(dto.getPassword());
        User user = userRepository
                .findFirstByUsernameEqualsIgnoreCaseAndPassword(dto.getUsername(), password)
                .orElseThrow(NotFoundException::new);
        if (!user.getEnable()) {
            throw new ValidationException("Your user is disable. contact with support.");
        }
        LimitedUserDto result = mapper.map(user, LimitedUserDto.class);
        result.setToken(jwtUtil.generateToken(result.getUsername()));
        return result;
    }

    public UserDto getUserByUsername(String username) throws NotFoundException {
        User user = userRepository.findFirstByUsername(username)
                .orElseThrow(NotFoundException::new);
        return mapper.map(user, UserDto.class);
    }

    public UserDto getById(Long id) throws NotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        return mapper.map(user, UserDto.class);
    }
}
