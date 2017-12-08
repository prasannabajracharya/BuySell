package edu.mum.service;

import edu.mum.dao.CommentRepository;
import edu.mum.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by prasannabajracharya on 8/12/17.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment add(Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Comment update(Comment comment, String id) {
        comment.setId(id);
        return commentRepository.save(comment);
    }

    @Override
    public Comment delete(Comment comment) {
        commentRepository.delete(comment);
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment get(String id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findAllByContentLike(String content) {
        return commentRepository.findAllByContentLike(content);
    }

    public List<Comment> findAllByCommentedOn(Date commentedOn) {
        return commentRepository.findAllByCommentedOn(commentedOn);
    }
}
