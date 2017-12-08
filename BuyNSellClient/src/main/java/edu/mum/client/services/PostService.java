package edu.mum.client.services;

import edu.mum.client.Constants;
import edu.mum.client.model.Comment;
import edu.mum.client.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rabin Shrestha on 8/12/2017.
 */
@Service
public class PostService extends AbstractService<Post>{

    public PostService() {
        super();
        baseUrl = Constants.POST_URL;
    }

    public Post add(Post Post){
        //System.out.println("posting post");
        return post(Post, null);
    }

    public void update(Post Post){
         put(Post, "/"+Post.getId());
    }

    public Post getById(String id){
        return get("/"+id);
    }

    public List<Post> getAll(){
        return getList(null);
    }

    public void delete(Long id){

        delete("/"+id);
    }

    public Post deleteComment(Comment comment, String postId){

        Post post = getById(postId);

        Comment delcomment=comment;
        for (Comment cmt : post.getListOfComments() ) {

            if(cmt.getId().equals(comment.getId())){
                delcomment=cmt;
                break;
            }
        }

        post.getListOfComments().remove(delcomment);

        update(post);

        return post;
    }


    public void interestedEmail(String postId){
        System.out.println("I am from interestedEmail Service.");
    }


}
