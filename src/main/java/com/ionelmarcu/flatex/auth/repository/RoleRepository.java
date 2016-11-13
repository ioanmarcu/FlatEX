package com.ionelmarcu.flatex.auth.repository;

import com.ionelmarcu.flatex.auth.entities.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Marcu on 13/11/2016.
 */

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
