package com.voronina.gb.service;

import com.voronina.gb.model.User;
import com.voronina.gb.repository.UserRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getAll(){
        return userRepository.getALl();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public User getOneUser(int id)  {
        return userRepository.getOneUser(id);
    }

    public User updateUser(User user){
        return userRepository.updateUser(user);
    }
}
