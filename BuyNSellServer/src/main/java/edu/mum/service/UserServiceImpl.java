package edu.mum.service;

import edu.mum.dao.RoleRepository;
import edu.mum.dao.UserRepository;
import edu.mum.domain.Role;
import edu.mum.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rabin Shrestha on 8/10/2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User add(User u) {
        return userRepository.save(u);
    }

    @Override
    public User get(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user, String id) {
        user.setId(id);
        // needs change here, it always saves new record
        return userRepository.save(user);
    }
    
    public User updateRole(User user, String role) {
    		List<Role> roles = new ArrayList<Role>();
    		Role r = new Role();
    		r.setName(role);
    		roles.add(r);
    		user.setRoles(roles);
    		roleRepository.save(r);
    		userRepository.save(user);
    		return user;
    }

    @Override
    public User delete(User user) {
        userRepository.delete(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public User findByUserName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public List<User> findAllByZipcode(String zipcode) {
        return userRepository.findAllByZipcode(zipcode);
    }

    @Override
    public User findUserByUserNameAndPassword(String username, String password) {
        return userRepository.findUserByUserNameAndPassword(username, password);

    }

    @Override
    public List<User> findUserByAddressIsLike(String address) {
        return userRepository.findAllUserByAddressIsLike(address);
    }

    @Override
    public Long deleteById(String userid) {

        return userRepository.deleteById(userid);
    }


}
