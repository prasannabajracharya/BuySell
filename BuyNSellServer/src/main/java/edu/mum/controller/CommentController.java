package edu.mum.controller;

import edu.mum.domain.Comment;
import edu.mum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by prasannabajracharya on 8/12/17.
 */
@RestController
@RequestMapping("/comment")
public class CommentController implements IController<Comment> {

    @Autowired
    private CommentService commentService;

    @Override
    @PostMapping("/")
    public Comment add(@RequestBody Comment comment) {
        return commentService.add(comment);
    }

    @Override
    @PutMapping("/{id}")
    public Comment update(@RequestBody Comment comment, @PathVariable("id") String id) {
        comment.setId(id);
        return commentService.update(comment, id);
    }

    @Override
    @DeleteMapping("/delete")
    public Comment delete(@RequestBody Comment comment, @RequestParam String id) {
        comment.setId(id);
        return commentService.delete(comment);
    }

    @Override
    @GetMapping("/")
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Comment get(@PathVariable("id") String id) {
        return commentService.get(id);
    }

    @GetMapping("/find/content/{contentValue}")
    public List<Comment> findAllByContentLike(@PathVariable("contentValue") String content) {
        return commentService.findAllByContentLike(content);
    }

    @GetMapping("/find/commentedOn/{commentedOnValue")
    public List<Comment> findAllByCommentedOn(@PathVariable Date commentedOn) {
        return commentService.findAllByCommentedOn(commentedOn);
    }
}
