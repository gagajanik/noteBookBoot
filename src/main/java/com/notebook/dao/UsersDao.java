package com.notebook.dao;

import com.notebook.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by root on 3/4/18.
 */
public interface UsersDao extends JpaRepository<Users,Long> {
    Users findFirstByUserNameAndPassword(String userName, String password);
}
