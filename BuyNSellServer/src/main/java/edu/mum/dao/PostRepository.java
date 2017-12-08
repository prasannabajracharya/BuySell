package edu.mum.dao;

import edu.mum.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by prasannabajracharya on 8/11/17.
 */
public interface PostRepository extends MongoRepository<Post, Integer> {
    Post findById(String id);

    List<Post> findAllByTitle(String title);

    List<Post> findAllByCatagory_Name(String categoryName);

}
