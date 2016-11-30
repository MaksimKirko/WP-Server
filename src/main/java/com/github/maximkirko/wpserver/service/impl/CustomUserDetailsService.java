package com.github.maximkirko.wpserver.service.impl;

import com.github.maximkirko.wpserver.dao.api.IUserDao;
import com.github.maximkirko.wpserver.datamodel.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by MadMax on 30.11.2016.
 */
public class CustomUserDetailsService implements UserDetailsService {

    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        com.github.maximkirko.wpserver.datamodel.User user = userDao.getByLogin(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

        return buildUserForAuthentication(user, authorities);


    }

    private User buildUserForAuthentication(com.github.maximkirko.wpserver.datamodel.User user, List<GrantedAuthority> authorities) {
        return new User(user.getLogin(),
                user.getPassword(), user.isLoggedIn(),
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Role role) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        setAuths.add(new SimpleGrantedAuthority(role.getType()));

        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

        return result;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public IUserDao getUserDao() {
        return userDao;
    }
}
