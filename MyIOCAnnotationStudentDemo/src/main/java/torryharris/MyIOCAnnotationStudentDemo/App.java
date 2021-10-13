package torryharris.MyIOCAnnotationStudentDemo;

import org.springframework.context.annotation.*;
import torryharris.Address;
import torryharris.Chair;
import torryharris.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("torryharris");
        context.refresh();
        
        //Setting the Student Details
        Student student = (Student) context.getBean("student");
        student.setStudId(101);
        student.setStuName("Pranav");
        
        //Setting the Chair Details
        Chair chair = (Chair) context.getBean("chair");
        chair.setColour("brown");
        chair.setType("wooden");
        
        //Setting the Address
        Address address = (Address) context.getBean("address");
        address.setDoorNo(27);
        address.setStreet("P3 Street");
        address.setCity("Madurai");
        address.setState("Tamilnadu");
        address.setPincode(625001);
        
        student.setAddress(address);
        student.setChair(chair);
        
       System.out.println(student);
       
       //Details of the Second Student 
       Student student1 = (Student) context.getBean("student");
       student1.setStudId(102);
       student1.setStuName("Nivas");
       
       Chair chair1 = (Chair) context.getBean("chair");
       chair1.setColour("Black");
       chair1.setType("Rolling");
       
       Address address1 = (Address) context.getBean("address");
       address1.setDoorNo(58);
       address1.setStreet("M5 Street");
       address1.setCity("Madurai");
       address1.setState("Tamilnadu");
       address1.setPincode(625001);
       
       student1.setAddress(address1);
       student1.setChair(chair1);
       
      System.out.println(student1);       
       
       context.close();
    }
}
