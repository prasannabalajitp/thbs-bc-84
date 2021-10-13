package torryharris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//Customer cust = new Customer();
@Component("customer")
public class Customer {
	private String custID;
	private String custName;
	private Address address;
	
	public Customer() {
		super();
	}

	//@Autowired
	public Customer(Address address) {
		super();
		this.address = address;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Address getAddress() {
		return address;
	}
	
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [custID=" + custID + ", custName=" + custName + ", address=" + address + "]";
	}
	
	
	
}
