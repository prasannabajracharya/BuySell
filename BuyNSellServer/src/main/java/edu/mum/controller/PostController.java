package edu.mum.controller;

import edu.mum.dao.CommentRepository;
import edu.mum.domain.Comment;
import edu.mum.domain.Post;
import edu.mum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by prasannabajracharya on 8/11/17.
 */
@Document
@RestController
@RequestMapping("/post")
public class PostController implements IController<Post> {

    @Autowired
    private PostService postService;
    @Autowired
    private CommentRepository cmRep;

    public Comment getByCommentId(String cmtId){
        return cmRep.findById(cmtId);
    }

    @Override
    @GetMapping("/")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @Override
    @PostMapping("/")
    public Post add(@RequestBody Post post) {
        return postService.add(post);
    }

    @Override
    @PutMapping("/{id}")
    public Post update(@RequestBody Post post, @PathVariable("id") String id) {
        post.setId(id);
        return postService.update(post, id);
    }

    @Override
    @DeleteMapping("/delete")
    public Post delete(@RequestBody Post post, @RequestParam String id) {
        post.setId(id);
        postService.delete(post);
        return post;
    }

    @Override
    @GetMapping("/{id}")
    public Post get(@PathVariable("id") String id) {
        return postService.get(id);
    }

    @GetMapping("/find/title/{titleValue}")
    public List<Post> findByTitle(@PathVariable("titleValue") String title) {
        return postService.findAllByTitle(title);
    }

    @GetMapping("/find/category/{categoryValue}")
    public List<Post> findByCatagory_Name(@PathVariable("categoryValue") String categoryName) {
        return postService.findAllByCatagory_Name(categoryName);
    }
}
