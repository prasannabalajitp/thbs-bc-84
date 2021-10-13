package torryharris.b84.MySpringJDBCDemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
    	EmployeeDAO  empdao = (EmployeeDAO)context.getBean("empDAO");

    						//DISPLAYING ALL THE RECORDS IN THE TABLE BEFORE UPDATE
    	System.out.println("DISPLAYING THE RECORDS BEFORE INSERTION");
    	for(Employee e: empdao.selectAll())
    	{
    		System.out.println(e);
    	}
    	
    						//INSERTING THE NEW RECORD IN THE TABLE 
    	Employee employee = new Employee();
    	employee.setEmployeeId(1002);
    	employee.setEmployeeName("Akash");
    	employee.setSalary(22000);
    	empdao.insert(employee);
    	System.out.println("INSERTION HAPPENS");
    	System.out.println(employee.toString());
    	System.out.println("One record inserted");
    	
    	
    	Employee employee1 = new Employee();
    	employee1.setEmployeeId(1003);
    	employee1.setEmployeeName("Ajith");
    	employee1.setSalary(30000);
    	empdao.insert(employee1);
    	
    	System.out.println(employee1.toString());
    	System.out.println("Second record inserted");

    	
    						//DISPLAY ALL THE RECORDS IN THE TABLE
    	System.out.println("DISPLAYING ALL THE RECORDS");
    	for(Employee e: empdao.selectAll())
    	{
    		System.out.println(e);
    	}
    	
    	System.out.println("*********************************");
    			
    	
    						//DISPLAY THE RECORD WITH GIVEN EMPID
    	System.out.println("DISPLAY THE RECORD OF THE 1001 : ");
    	Employee find = empdao.selectAEmployee(1001);
    	System.out.println(find);
    }
}
