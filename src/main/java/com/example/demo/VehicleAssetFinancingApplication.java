package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class VehicleAssetFinancingApplication {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(VehicleAssetFinancingApplication.class, args);
	}

	@PostConstruct
	public void setupDbWithData(){
		
		Map<String,String> usersMap = new HashMap<String,String>();
		usersMap.put("John", "password123");
		usersMap.put("David", "password123");
		usersMap.put("Peter", "password123");
		usersMap.put("Smith", "password123");
		
		for(String userName : usersMap.keySet()) {
			User user= new User(userName, usersMap.get(userName));
			user= userRepository.save(user);
		}		
	}
}
