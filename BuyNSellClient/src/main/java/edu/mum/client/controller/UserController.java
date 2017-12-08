package edu.mum.client.controller;

import edu.mum.client.model.User;
import edu.mum.client.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.Session;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Rabin Shrestha on 8/12/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService uService;

    @GetMapping("/")
    public String home(Model model) {
        //User p = uService.getById("598e7ea5fb3cd11dac9d4189");
        List<User> users = uService.getAll();
        model.addAttribute("users", users);
        //uService.getUsers();
        System.out.println("list:" + users);
        return "users";
    }

    @PostMapping("/")
    public String registerUser(Model model, User user) {
        System.out.println("Inside registration controller: RegistrationUser");
        User newUser = uService.add(user);
        System.out.println("The registered user is " + newUser);
        return "profile";
    }

    @GetMapping("/signup")
    public String registration(Model model) {
        return "signup";
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String loadProfile(Model model, @PathVariable("id") String id) {
       /*
       ===============================
       MOCK USER OBJECT FOR TEST
       ===============================
        User user = new User();
        user.setId("59910cfdfb3cd1267c8f4b1b");
        user.setUserName("user1");
        user.setFirstName("Rabin ");
        user.setLastName("Shrestha");
        user.setPhotoUrl("src/main/resources/statis/rabin.jpg");
        user.setAddress("100 N 4th street");
        user.setCreatedOn(Calendar.getInstance().getTime());
        user.setLastLogIn(Calendar.getInstance().getTime());
        user.setEmail("rabinshrestha677@gmail.com");
        user.setEnabled(true);
        user.setZipcode("52557");
        user.setPassword("password");
        user.setPhoneNo("9857654584");
        System.out.println("Loading user");
        */
        User user = uService.getById(id);
        model.addAttribute(user);
        return "profile";
    }
    @RequestMapping(value = "/profile/{uid}", method = RequestMethod.POST)
    public String updateProfile(User userInfo, MultipartFile imageName ,@PathVariable("uid") String uid)  throws IOException {

        User loggedinUser= uService.getById(uid); // you need to fetch it from session actually
        String fileName = "";
        if (imageName != null) {
            byte[] bytes = imageName.getBytes();
            fileName = imageName.getOriginalFilename();
           // String fileLocation = new File("src\\main\\resources\\static\\images").getAbsolutePath() + "\\" + fileName;
            String fileLocation = new File("src/main/webapp/static/images").getAbsolutePath() + "\\" + fileName;
            // String ss = new File("src/main/resources/static/images").getAbsolutePath() + "\\" + fileName;
            FileOutputStream fos = new FileOutputStream(fileLocation);
            fos.write(bytes);
            fos.close();
        }

        loggedinUser.setUserName(userInfo.getUserName());
        loggedinUser.setFirstName(userInfo.getFirstName());
        loggedinUser.setLastName(userInfo.getLastName());
        loggedinUser.setAddress(userInfo.getAddress());
        loggedinUser.setEmail(userInfo.getEmail());
        loggedinUser.setZipcode(userInfo.getZipcode());
        loggedinUser.setPassword(userInfo.getPassword());
        loggedinUser.setPhoneNo(userInfo.getPhoneNo());
        // Photo url just processed
        loggedinUser.setPhotoUrl(fileName);
        System.out.println("Photo url is " + fileName);

        User updatedUser = uService.update(loggedinUser);
        // TO do
        // loggedIn user object in session is to be changed by updated user
        System.out.println("updated user information is " + updatedUser);
        return "postList";
    }


}
