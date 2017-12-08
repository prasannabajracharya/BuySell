package edu.mum.dao;

import edu.mum.domain.Catagory;
import edu.mum.domain.WishList;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yentran
 */
public interface CatagoryRepository extends MongoRepository<Catagory, String> {
    public Catagory findByName(String name);

    public Catagory findById(String id);

    public String deleteById(String userid);
    
}
