package edu.mum.client;

import edu.mum.client.config.MvcConfig;
import edu.mum.client.model.User;
import edu.mum.client.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Calendar;

@SpringBootApplication
@Import({MvcConfig.class})
public class BuynsellclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuynsellclientApplication.class, args);
        System.out.println(" Client Application started");

        User user=new User();
        user.setId("userId1");
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
        UserService userService=new UserService();
        // update test
        //userService.update(user);


    }
}
