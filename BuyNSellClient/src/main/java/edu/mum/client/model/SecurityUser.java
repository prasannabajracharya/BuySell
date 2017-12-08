package edu.mum.client.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SecurityUser extends User implements UserDetails {


    private static final long serialVersionUID = 1L;

    public SecurityUser(User suser) {

        if (suser != null)

        {

            this.setId(suser.getId());

            this.setUserName(suser.getUserName());


            this.setPassword(suser.getPassword());


            this.setRoles(suser.getRoles());

        }

    }


    @Override
    public Collection<GrantedAuthority> getAuthorities() {


        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        List<Role> userRoles = this.getRoles();


        if (userRoles != null)

        {

         
            for (Role role : userRoles) {
            	
            	//System.out.println(role.getName());

            	
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());

                authorities.add(authority);

            }

        }

        return authorities;

    }


    @Override
    public String getPassword() {

        return super.getPassword();

    }


    @Override
    public String getUsername() {

        return super.getUserName();

    }


    @Override
    public boolean isAccountNonExpired() {

        return true;

    }


    @Override
    public boolean isAccountNonLocked() {

        return true;

    }


    @Override
    public boolean isCredentialsNonExpired() {

        return true;

    }


    @Override
    public boolean isEnabled() {

        return true;

    }


}