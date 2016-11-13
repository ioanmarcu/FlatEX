package com.ionelmarcu.flatex.auth.service;

import com.ionelmarcu.flatex.auth.entities.User;

/**
 * Created by Marcu on 13/11/2016.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
