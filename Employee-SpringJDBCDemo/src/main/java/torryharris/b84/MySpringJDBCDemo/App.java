package torryharris.b84.MySpringJDBCDemo;

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

    	Employee employee = new Employee();
    	employee.setEmployeeId(1002);
    	employee.setEmployeeName("Akash");
    	employee.setSalary(22000);
    	empdao.insert(employee);
    	
    	System.out.println("One record inserted");
    	
    	
    	Employee employee1 = new Employee();
    	employee1.setEmployeeId(1003);
    	employee1.setEmployeeName("Ajith");
    	employee1.setSalary(30000);
    	empdao.insert(employee1);
    	
    	System.out.println("Second record inserted");
    	
   
    }
}
