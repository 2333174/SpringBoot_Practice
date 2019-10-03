package com.example.demo.primaryData;

import com.example.demo.primaryData.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByNameAndAge(@Param("name") String name, @Param("age") Integer age);
}
