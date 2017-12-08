package edu.mum.dao;

import edu.mum.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Rabin Shrestha on 8/10/2017.
 */
public interface UserRepository extends MongoRepository<User, Integer> {

    User findByUserName(String username);

    User findById(String id);

    User findByEmail(String email);

    List<User> findAllByZipcode(String zipcode);

    User findUserByUserNameAndPassword(String username, String password);

    List<User> findAllUserByAddressIsLike(String address);

    Long deleteById(String userid);
}
