package com.notebook.entity;

import javax.persistence.*;

/**
 * Created by root on 3/4/18.
 */
@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_USERS")
    @SequenceGenerator(name = "SEQ_USERS", sequenceName = "SEQ_USERS")
    private Long id;
    private String userName;
    private String password;
    private String userRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
