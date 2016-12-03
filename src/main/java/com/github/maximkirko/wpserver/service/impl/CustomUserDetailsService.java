package com.github.maximkirko.wpserver.service.impl;


import com.github.maximkirko.wpserver.datamodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private com.github.maximkirko.wpserver.service.api.IUserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        User user = userService.getByLogin(login);
        System.out.println("User : " + user);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getType()));
        System.out.print("authorities :" + authorities);

        return authorities;
    }

}
