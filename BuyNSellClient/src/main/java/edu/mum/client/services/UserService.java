package edu.mum.client.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.client.Constants;
import edu.mum.client.model.Catagory;
import edu.mum.client.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rabin Shrestha on 8/12/2017.
 */
@Service
public class UserService extends AbstractService<User>{
	
	private  RestTemplate restTemplate;

    public UserService() {
    
        super();
        this.restTemplate = new RestTemplate();
        baseUrl = Constants.USER_URL;
    }

    public User add(User user){
        System.out.println("registering new user");
        return post(user, null);
    }

    public User update(User user){
        System.out.println("updating user information for :"+user);
        return update(user, user.getId());
    }

    public User getUserByName(String username) {
    		return this.restTemplate.getForEntity("http://localhost:8080/user/getByName/" + username, User.class).getBody();
    		 
    }
    
    public User getById(String id){
        return get("/"+id);
    }

    public List<User> getAll(){
        return getList(null);
    }

    public void delete(Long id){
        delete("/"+id);
    }


}
