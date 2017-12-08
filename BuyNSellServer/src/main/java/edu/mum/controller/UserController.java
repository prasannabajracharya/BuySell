package edu.mum.controller;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Rabin Shrestha on 8/10/2017.
 */
@RestController
@RequestMapping("/user")

public class UserController implements IController<User> {
    @Autowired
    private UserService userService;


    @Override
    @PostMapping("/")
    public User add(@RequestBody User user) {
        System.out.println("user:" + user);
        user.setCreatedOn(Calendar.getInstance().getTime());
        user.setLastLogIn(Calendar.getInstance().getTime());
        
        return userService.add(user);
    }

    @Override
    @PostMapping("/update/{id}")
    public User update(@RequestBody User user, @PathVariable("id") String id) {
        System.out.println("Update request user id:" + id);
        System.out.println("Update request user on ob:" + user.getId());
        user.setId(id);
        return userService.update(user, id);
    }

    @PostMapping("/updateRole/{name}")
    public User updateRole(@RequestBody User user, @PathVariable("name") String name) {
    	
    		return userService.updateRole(user, name);
    }
    @Override
    @DeleteMapping("/delete")
    public User delete(@RequestBody User user, @RequestParam String id) {
        System.out.println("No of row deleted :" + userService.deleteById(id));
        return user;
    }

    
    @Override
    @GetMapping(value = "/" , produces = "application/json")
    public List<User> getAll() {
        return userService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public User get(@PathVariable("id") String id) {
        return userService.get(id);
    }


    @PostMapping("/find/username/{uname}")
    public User getUserByUserName(@PathVariable("uname") String uname) {
        return userService.findByUserName(uname);
    }

    @PostMapping("/find/email/")
    public User getUserByEmail(@RequestBody User user) {
        return userService.findByEmail(user.getEmail());
    }

    @GetMapping("/find/zipcode/{zipcode}")
    public List<User> getUserListByZipCode(@PathVariable("zipcode") String zipcode) {
        return userService.findAllByZipcode(zipcode);
    }

    @GetMapping("/find/address/{address}")
    public List<User> getUserListByAddress(@PathVariable("address") String address) {
        return userService.findUserByAddressIsLike(address);
    }

    @PostMapping("/validate/")
    public String validateUser(@RequestBody User user) {
        User usr = userService.findUserByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (usr != null)
            return "{\"success\":true}";
        else
            return "{\"success\":false}";
    }

    @GetMapping("/getByName/{username}")
    public User getUserByName(@PathVariable("username") String username) {
    		User user = userService.findByUserName(username);
    		return user;
    }
}


