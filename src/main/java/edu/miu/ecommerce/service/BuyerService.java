package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Buyer;
import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuyerService {

    Buyer findBuyerById(long id);

    Iterable<Buyer> findAllBuyers();

    Buyer addBuyer(Buyer buyer);

    void deleteBuyer(long id);

    List<Order> findBuyerOrdersById(long id);

    Review addReviewByBuyerId(Review review, long id);

    Order placeOrderByBuyerId(Order order, long id);

    Order cancelOrderByBuyerId(Order order, long id);


}
