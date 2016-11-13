package com.ionelmarcu.flatex.auth.service;

import com.ionelmarcu.flatex.auth.entities.Role;
import com.ionelmarcu.flatex.auth.entities.User;
import com.ionelmarcu.flatex.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Marcu on 13/11/2016.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user!=null) {
            authorities =
                    buildUserAuthority(user.getRoles());
        }
        org.springframework.security.core.userdetails.User Springuser = buildUserForAuthentication(user, authorities);
        return Springuser;
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
                                                                                          List<GrantedAuthority> authorities) {
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    true, true, true, true, authorities);
        }
        return new org.springframework.security.core.userdetails.User("default", "default", new HashSet<>());
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        // Build user's authorities
        for (Role role : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new ArrayList<>(setAuths);
    }
}
