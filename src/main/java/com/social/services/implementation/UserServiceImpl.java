package com.social.services.implementation;

import com.social.entities.User;
import com.social.repositories.UserRepository;
import com.social.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Katarzyna on 2017-03-26.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public User getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public User registerNewAccount(User user) {

        if (emailExist(user.getEmail())) {

        }

        User savedUser=userRepository.save(user);

        return savedUser;
    }
}
