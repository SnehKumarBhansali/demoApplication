package com.demo.controller;

import java.util.HashMap;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.UserService;

@RestController
public class UserController {

	@Autowired 
	UserService us;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<?>  getAll() {
		HashMap<String, User> hashTable = null;
		hashTable = us.getAll();
		return new ResponseEntity<HashMap<String, User>>(hashTable, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<?> serverStatus(){
		return new ResponseEntity<String>("Status : Server is up and Ready to serve " , HttpStatus.OK);
	}
	

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET) 
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {
	   User user = us.getUser(id);
       return new ResponseEntity<User>(user, HttpStatus.OK); 
    }
	 
}
