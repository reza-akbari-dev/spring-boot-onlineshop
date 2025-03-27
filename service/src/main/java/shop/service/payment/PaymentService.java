package shop.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dataaccess.repository.payment.PaymentRepository;

@Service
public class PaymentService {
    private final PaymentRepository repository;

    @Autowired
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }
}
