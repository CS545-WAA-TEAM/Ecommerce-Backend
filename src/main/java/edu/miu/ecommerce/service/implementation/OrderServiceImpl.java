package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Override
    public Iterable<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order getOrderById(long id) {
        return null;
    }

    @Override
    public Order addOrder(Order order) {
        return null;
    }

    @Override
    public void deleteOrder(long id) {

    }

    @Override
    public Product findProductByOrderId() {
        return null;
    }
}
