package edu.mum.client.services;

import edu.mum.client.Constants;
import edu.mum.client.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by prasannabajracharya on 8/14/17.
 */
@Service
public class CommentService extends AbstractService<Comment> {

    public CommentService() {
        super();
        baseUrl = Constants.COMMENT_URL;
    }

    public Comment add(Comment comment){
        //System.out.println("I am from comment service");
        return post(comment, null);
    }

    public Comment update(Comment comment){
        return post(comment, "/" + comment.getId());
    }

    public Comment getById(String id){
        return get("/" + id);
    }

    public List<Comment> getAll(){

        return getList(null);
    }

    public void delete(Long id){

        delete("/"+id);
    }
}
