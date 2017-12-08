package edu.mum.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.mum.client.model.SecurityUser;
import edu.mum.client.model.User;


public class CustomUserDetailsService implements UserDetailsService {
    @Autowired 
    private UserService suserService;//code7

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = suserService.getUserByName(userName); //code8
        System.out.println(user);
        if (user == null) {

            throw new UsernameNotFoundException("UserName " + userName + " not found");

        }
   
        SecurityUser securityUser = new SecurityUser(user);
       // Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        
       // authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return securityUser; //code9

    }

}
