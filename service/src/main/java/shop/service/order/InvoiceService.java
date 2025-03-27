package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.repository.order.InvoiceItemRepository;
import shop.dataaccess.repository.order.InvoiceRepository;

@Service
public class InvoiceService {
    private final InvoiceRepository repository;
    private final InvoiceItemRepository itemRepository;

    @Autowired
    public InvoiceService(InvoiceRepository repository,
            InvoiceItemRepository itemRepository) {
        this.repository = repository;
        this.itemRepository = itemRepository;
    }
}
