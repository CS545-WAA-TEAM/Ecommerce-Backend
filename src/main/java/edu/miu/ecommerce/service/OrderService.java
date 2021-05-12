package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Product;


public interface OrderService {

    Iterable<Order> getAllOrders();

    Order getOrderById(long id);

    Order addOrder(Order order);

    void deleteOrder(long id);

    Product findProductByOrderId();


}
