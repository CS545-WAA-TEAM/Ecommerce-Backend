package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Review;
import edu.miu.ecommerce.service.ReviewService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
    @Override
    public Iterable<Review> getAllReviews() {
        return null;
    }

    @Override
    public Review getReviewById(long id) {
        return null;
    }

    @Override
    public Review addReview(Review review) {
        return null;
    }

    @Override
    public void deleteReview(long id) {

    }
}
