package edu.mum.client.controller;

import edu.mum.client.model.Comment;
import edu.mum.client.model.Post;
import edu.mum.client.model.User;
import edu.mum.client.services.PostService;
import edu.mum.client.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Rabin Shrestha on 8/12/2017.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String showAllPosts(Model model) {

        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "postList";
    }

    @GetMapping("/add")
    public String addPost(){

        return "addPost";
    }

    @PostMapping("/add")
    public String addPost(Model model, Post post) {

       // String view = "redirect:/post/list";

       // model.addAttribute("post", post);
        Post newPost = postService.add(post);
        System.out.println("New post added:"+newPost);

//        if(!result.hasErrors()){
//            return "redirect:/post/list";
//        } else {
//            view = "addPost";
//        }
//
//        return view;
        return "redirect:/post/list";

    }

    @GetMapping("/detail/{id}")
    public String detailPost(Model model, @PathVariable("id") String id){

        Post post = postService.getById(id);
        model.addAttribute("post",post);

        User poster=userService.getById(post.getUserId()); // need to replace by post.getUserId()
        model.addAttribute("poster",poster);
        return "postDetail";
    }

    @PostMapping("/addComment/{postId}")
    public String addPostComment(Model model, Comment comment, @PathVariable("postId") String postId) {

        System.out.println("I am from add Post comment " + comment + postId);
        Post post = postService.getById(postId);

        comment.setCommentedOn(Calendar.getInstance().getTime());
        comment.setUserId("59926786ba478e144fb629dd");

        String commentId=post.getId()+post.getUserId()+comment.getCommentedOn();
        comment.setId(commentId);

        post.getListOfComments().add(comment);

        System.out.println("New comment added:"+post.getListOfComments());
        postService.update(post);

        model.addAttribute(post);
        return "redirect:/post/detail/"+postId;
    }

    @PostMapping("/deleteComment/{postId}")
    public String deletePostComment(Model model, Comment comment, @PathVariable("postId") String postId) {

        Post post = postService.deleteComment(comment, postId);

        model.addAttribute(post);
        return "redirect:/post/detail/"+postId;
    }

    @GetMapping("/interested/{postId}")
    public String interestedEmail(@PathVariable("postId") String postId){
        System.out.println("I am from interestedEmail Controller.");
        postService.interestedEmail(postId);
        return "redirect:/post/detail/"+postId;

    }

}
