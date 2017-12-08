package edu.mum.service;

import edu.mum.domain.User;

import java.util.List;

/**
 * Created by Rabin Shrestha on 8/10/2017.
 */
public interface UserService extends IService<User> {
    public User findByEmail(String email);

    public User findByUserName(String name);

    List<User> findAllByZipcode(String zipcode);

    User findUserByUserNameAndPassword(String username, String password);

    List<User> findUserByAddressIsLike(String address);

    Long deleteById(String userid);
    
    public User updateRole(User user, String role);

}