package edu.mum.dao;

import edu.mum.domain.UserReview;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prasannabajracharya on 8/12/17.
 */
public interface UserReviewRepository extends MongoRepository<UserReview, String> {
}
