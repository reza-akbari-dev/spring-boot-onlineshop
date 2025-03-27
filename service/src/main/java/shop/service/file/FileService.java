package shop.service.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.repository.file.FileRepository;

@Service
public class FileService {
    private final FileRepository repository;
    @Autowired
    public FileService(FileRepository repository) {
        this.repository = repository;
    }
}
