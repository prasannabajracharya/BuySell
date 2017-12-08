package edu.mum.dao;

import edu.mum.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by prasannabajracharya on 8/12/17.
 */
public interface CommentRepository extends MongoRepository<Comment, Integer> {
    public Comment findById(String id);

    public List<Comment> findAllByContentLike(String content);

    public List<Comment> findAllByCommentedOn(Date commentedOn);
}
