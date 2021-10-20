package com.th.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private int pquantity;
	private int uprice;
	public Product() {
		
	}
	
	
	public Product(int pid, String pname, int pquantity, int uprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pquantity = pquantity;
		this.uprice = uprice;
	}


	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public int getUprice() {
		return uprice;
	}
	public void setUprice(int uprice) {
		this.uprice = uprice;
	}
	
	
}
