package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Buyer;
import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Review;
import edu.miu.ecommerce.repository.BuyerDAO;
import edu.miu.ecommerce.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerDAO buyerDAO;

    @Override
    public Buyer findBuyerById(long id) {
        return buyerDAO.findById(id).orElseThrow();
    }

    @Override
    public Iterable<Buyer> findAllBuyers() {
        return buyerDAO.findAll();
    }

    @Override
    public Buyer addBuyer(Buyer buyer) {
        return buyerDAO.save(buyer);
    }

    @Override
    public void deleteBuyer(long id) {
        buyerDAO.deleteById(id);
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
