package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public List<User> getAll(){
        List<User> users= userRepository.findAll();
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id ){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
        return "success";
    }

    @GetMapping("/get")
    public List<User> getUserByNameAndAge(@RequestParam String name,@RequestParam Integer age){
        List<User> users=userRepository.findByNameAndAge(name,age);
        return users;
    }

    @GetMapping("/insert")
    public String insertUser(User user){
        userRepository.save(user);
        return "insert success";
    }
}
