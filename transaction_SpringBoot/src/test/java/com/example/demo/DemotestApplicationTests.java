package com.example.demo;

import com.example.demo.primaryData.User;
import com.example.demo.primaryData.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemotestApplicationTests {

	@Autowired
	UserRepository userRepository;
	@Test
	public void contextLoads() {
	}

	@Test
	@Transactional
	public void test(){

		//name字段限长5个字符
		userRepository.save(new User("AAA", 10));
		userRepository.save(new User("BBB", 20));
		userRepository.save(new User("CCC", 30));
		userRepository.save(new User("DDD", 40));
		//这里name字段超过5个字符会出现异常
		userRepository.save(new User("EEEEEE", 50));
		userRepository.save(new User("FFF", 60));
		userRepository.save(new User("GGG", 70));
		userRepository.save(new User("HHH", 80));
		userRepository.save(new User("III", 90));
		userRepository.save(new User("JJJ", 100));

	}
}
