package com.thbs.b84.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.b84.model.Person;
import com.thbs.b84.repository.PersonRepository;



@RestController
@RequestMapping("/persons")
public class PersonController {

	@GetMapping("/getAllPersonDetails")
	public ResponseEntity <List<Person>>getAllPersonDetails()
	{
	
		PersonRepository pr = new PersonRepository();
		List<Person> plist = pr.getAllPersonDetails();
		return new ResponseEntity<List<Person>>(plist, HttpStatus.OK);
	}
	@GetMapping("/getAPerson/{id}")
	public ResponseEntity<Person> getBookById(@PathVariable int id)
	{
		PersonRepository br = new PersonRepository();
		Person b = br.getAPerson(id);
		if(b!=null)
		{
			return new ResponseEntity<Person>(b,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
	}
}
