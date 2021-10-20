package com.thbs.b84.repository;

import java.util.ArrayList;
import java.util.List;

import com.thbs.b84.model.Person;

public class PersonRepository {
	List<Person> plist;
	
	public PersonRepository()
	{
		plist = new ArrayList<Person>();
		
		Person p1 =new Person();
		p1.setpId(100);
		p1.setpName("Prasanna");
		p1.setpAge(24);
		p1.setpCity("Madurai");
		p1.setpState("TN");
		
		Person p2 = new Person();
		p2.setpId(101);
		p2.setpName("Tejas");
		p2.setpAge(23);
		p2.setpCity("Chennai");
		p2.setpState("TN");
		
		Person p3 = new Person();
		p3.setpId(102);
		p3.setpName("Ajith");
		p3.setpAge(24);
		p3.setpCity("Trichy");
		p3.setpState("TN");
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
	}
	
	public List<Person> getAllPersonDetails()
	{
		return plist;
	}
	
	public Person getAPerson(int pId)
	{
		for(Person p:plist)
		{
			if(p.getpId()==pId)
			{
				return p;
			}
		}
		return null;
	}
}
