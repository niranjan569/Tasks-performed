package com.springservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springservice.dao.UserService;
import com.springservice.domain.User;


@RestController
@RequestMapping("/service/user/")
public class SpringServiceController {
	UserService userService=new UserService();
	     	    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getUser(@PathVariable int id) {
		User user=userService.getUserById(id);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
//	@ResponseStatus(value = HttpStatus.CONFLICT)  to set status code
	public List<User> getAllUsers() {
		List<User> users=userService.getAllUsers();
		return users;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public void addUser(@RequestBody User user){
		userService.addUser(user);
	}
	
	@RequestMapping(value="/delete/{id}" , method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable int id){
		userService.deleteUser(id);
	}
	
}