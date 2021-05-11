package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Buyer;
import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Review;
import edu.miu.ecommerce.service.BuyerService;

import java.util.List;

public class BuyerServiceImpl implements BuyerService {
    @Override
    public Buyer findBuyerById(long id) {
        return null;
    }

    @Override
    public Iterable<Buyer> findAllBuyers() {
        return null;
    }

    @Override
    public Buyer addBuyer(Buyer buyer) {
        return null;
    }

    @Override
    public void deleteBuyer(long id) {

    }

    @Override
    public List<Order> findBuyerOrdersById(long id) {
        return null;
    }

    @Override
    public Review addReviewByBuyerId(Review review, long id) {
        return null;
    }

    @Override
    public Order placeOrderByBuyerId(Order order, long id) {
        return null;
    }

    @Override
    public Order cancelOrderByBuyerId(Order order, long id) {
        return null;
    }
}
