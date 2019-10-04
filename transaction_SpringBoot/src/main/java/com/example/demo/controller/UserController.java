package com.example.demo.controller;

import com.example.demo.primaryData.User;
import com.example.demo.primaryData.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

//    //一个事务
//    @GetMapping("/test")
//    @Transactional(rollbackOn = Exception.class)
//    //通过此注解保持事务完整性，事务中任何一个操作发生异常，所有操作都需要回滚回去
//    public String test() throws Exception {
//
//       test1();
//        return "Success";
//
//    }
//
//    @Transactional(rollbackOn = Exception.class)
//    public String test1() throws Exception {
//
//
//
//    }
}
