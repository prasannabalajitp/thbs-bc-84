package torryharris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
@Component("student")
public class Student {
	private int studId;
	private String stuName;
	private Address address;
	private Chair chair;
	
	
	@Autowired
	public Student(Address address, Chair chair) {
		super();
		this.address = address;
		this.chair = chair;
	}
	
						//Getters and Setters
	public int getStudId() {
		return studId;
	}


	public void setStudId(int studId) {
		this.studId = studId;
	}


	public String getStuName() {
		return stuName;
	}


	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Chair getChair() {
		return chair;
	}


	public void setChair(Chair chair) {
		this.chair = chair;
	}

						//ToString
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", stuName=" + stuName + ", address=" + address + ", chair=" + chair + "]";
	}
	
	
}
