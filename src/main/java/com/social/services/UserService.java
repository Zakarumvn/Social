package com.social.services;

import com.social.entities.User;

/**
 * Created by Katarzyna on 2017-03-26.
 */
public interface UserService {

    public User saveUser(User user);
    public boolean emailExist(String email);
    public User getByUsername(String username);
    public User registerNewAccount(User user);
}
