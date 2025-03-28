package shop.dataaccess.repository.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dataaccess.entity.file.File;
@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
