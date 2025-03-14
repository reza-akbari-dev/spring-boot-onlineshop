package shop.dataaccess.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.user.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
