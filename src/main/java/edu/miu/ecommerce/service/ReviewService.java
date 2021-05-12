package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Review;


public interface ReviewService {

    Iterable<Review> getAllReviews();

    Review getReviewById(long id);

    Review addReview(Review review);

    void deleteReview(long id);
}
