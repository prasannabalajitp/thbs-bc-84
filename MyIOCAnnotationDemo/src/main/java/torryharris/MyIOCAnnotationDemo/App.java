package torryharris.MyIOCAnnotationDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import torryharris.Address;
import torryharris.Customer;

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
    	
    	Customer customer = (Customer)context.getBean("customer");
    	customer.setCustID("1001");
    	customer.setCustName("Prasanna");
    	Address address  = customer.getAddress();
    	address.setDoorNo(27);;
    	address.setStreet("P3 Street");
    	address.setCity("Madurai");
    	address.setState("Tamilnadu");
    	address.setPincode(625001);
    	
    	
    	System.out.println(customer);
    	
    	Customer customer1 = (Customer)context.getBean("customer");
    	customer1.setCustID("1002");
    	customer1.setCustName("Tejas");
    	Address address1  = customer.getAddress();
    	address1.setDoorNo(58);;
    	address1.setStreet("M5 Street");
    	address1.setCity("Madurai");
    	address1.setState("Tamilnadu");
    	address1.setPincode(625001);
    	
    	
    	System.out.println(customer1);
    	context.close();
    }
}
