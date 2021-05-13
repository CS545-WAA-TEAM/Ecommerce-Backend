package edu.miu.ecommerce.controller;

import edu.miu.ecommerce.domain.Review;
import edu.miu.ecommerce.repository.ReviewDAO;
import edu.miu.ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @PatchMapping("/reviews/{id}/approve")
    public Review approveReview(@PathVariable long id){
        return reviewService.approveReview(id);
    }
}
