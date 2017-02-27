/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */

package cloud.simple.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.simple.config.RibbonConfiguration;
import cloud.simple.model.User;
//import cloud.simple.service.UserServiceProvider.FeignUserService;
import cloud.simple.service.UserService;



@RestController
@RibbonClient(name = "microservice-provider", configuration = RibbonConfiguration.class)
public class UserController {
		
	@Autowired
	UserService userService;
	
//	@Autowired
//	FeignUserService feignUserService;

	@RequestMapping(value="/user-{option}/users")
	public ResponseEntity<List<User>> readUserInfo(@PathVariable String option){
		System.out.println("aaaa-->"+option);
		List<User> users=userService.readUserInfo();		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
}
