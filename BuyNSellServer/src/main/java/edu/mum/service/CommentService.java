package edu.mum.service;

import edu.mum.domain.Comment;

import java.util.Date;
import java.util.List;

/**
 * Created by prasannabajracharya on 8/12/17.
 */
public interface CommentService extends IService<Comment> {
    public List<Comment> findAllByContentLike(String content);

    public List<Comment> findAllByCommentedOn(Date commentedOn);
}
