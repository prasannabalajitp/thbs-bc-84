package torryharris.b84.SpringJDBCDemo;

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
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/java/beans.xml");
    	
    	BookDAO1 dao = (BookDAO1)ctx.getBean("bookDAO");
    	
    		//SELECTING THE BOOK FROM THE DATABASE
    	Book search = dao.select(1);
    	System.out.println(search.getBookId()+"		"+search.getBookName()+"	"+search.getBookPrice());
    	
    	
    		//INSERTING THE NEW BOOK 
    	Book book = new Book();
    	book.setBookId(5);
    	book.setBookName("Java");
    	book.setBookPrice(20000);
    	dao.insert(book);
    	System.out.println(book.toString());
    	System.out.println("Book inserted...");
    	
    	Book book1 = new Book();
    	book1.setBookId(6);
    	book1.setBookName("One Indian Girl");
    	book1.setBookPrice(900);
    	dao.insert(book1);
    	System.out.println(book1.toString());
    	System.out.println("Second Book Inserted");
    	
    	((ClassPathXmlApplicationContext)ctx).close();



//    	ctx.close();
    }
}
