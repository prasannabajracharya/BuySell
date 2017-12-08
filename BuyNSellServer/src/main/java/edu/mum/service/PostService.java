package edu.mum.service;

import edu.mum.domain.Post;

import java.util.List;

/**
 * Created by prasannabajracharya on 8/11/17.
 */
public interface PostService extends IService<Post> {
    List<Post> findAllByTitle(String title);

    List<Post> findAllByCatagory_Name(String catagoryName);
}
