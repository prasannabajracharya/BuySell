package edu.mum.dao;

import edu.mum.domain.WishList;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yentran
 */
public interface WishListRepository extends MongoRepository<WishList, String> {

    //	public WishList findByCatagory(WishList wl);
    public WishList findByName(String name);
    public WishList findById(String id);
    public void delete(String id);
}
