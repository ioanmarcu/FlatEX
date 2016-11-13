package com.ionelmarcu.flatex.auth.repository;

import com.ionelmarcu.flatex.auth.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Marcu on 13/11/2016.
 */
public interface UserRepository  extends CrudRepository<User, Integer>{
    User findByUsername(String username);
}
