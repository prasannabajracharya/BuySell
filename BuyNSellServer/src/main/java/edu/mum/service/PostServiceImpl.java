package edu.mum.service;

import edu.mum.dao.PostRepository;
import edu.mum.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by prasannabajracharya on 8/11/17.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post add(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post, String id) {
        post.setId(id);
        return postRepository.save(post);
    }

    @Override
    public Post delete(Post post) {
        postRepository.delete(post);
        return post;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post get(String id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAllByTitle(String title) {
        return postRepository.findAllByTitle(title);
    }

    @Override
    public List<Post> findAllByCatagory_Name(String catagoryName) {
        return postRepository.findAllByCatagory_Name(catagoryName);
    }
}

