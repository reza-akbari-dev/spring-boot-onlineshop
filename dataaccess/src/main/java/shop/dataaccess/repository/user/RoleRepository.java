package shop.dataaccess.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.user.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
