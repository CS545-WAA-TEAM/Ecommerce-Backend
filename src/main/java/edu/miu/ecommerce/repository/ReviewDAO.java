package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewDAO extends CrudRepository<Review, Long> {
}
