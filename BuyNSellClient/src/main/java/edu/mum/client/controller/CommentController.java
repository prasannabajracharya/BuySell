package edu.mum.client.controller;

import edu.mum.client.model.Comment;
import edu.mum.client.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by prasannabajracharya on 8/14/17.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public String addComment(Model model, Comment comment){
        System.out.println("I am from Comment controller" + comment);
        commentService.add(comment);
        return "redirect:/post/detail/5991a4ffba478e0333f835ab";
    }

    @GetMapping("/list")
    public String showAllComments(Model model) {

        List<Comment> commentList = commentService.getAll();
        model.addAttribute("commentList", commentList);
        return "commentList";
    }

}
