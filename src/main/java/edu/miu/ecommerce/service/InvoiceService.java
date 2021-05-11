package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Invoice;
import edu.miu.ecommerce.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    Invoice generateInvoice(List<Order> orders);
}
