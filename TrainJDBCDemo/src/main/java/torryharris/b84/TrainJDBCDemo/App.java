package torryharris.b84.TrainJDBCDemo;

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
    	
    	TrainDAO1 dao = (TrainDAO1) ctx.getBean("trainDAO");
    	
    	
    	Train search = dao.select(1001);
    	System.out.println("Train no. : "+search.getTrainNo()+"\t"+"Train Name : "+search.getTrainName()+"\t"+"From : "+search.getSource()
    						+"\t"+"Destination : "+search.getDestination()+"\t"+"Price : "+search.getPrice());
    	System.out.println();
    	Train search1 = dao.select(1003);
    	System.out.println("Train no. : "+search1.getTrainNo()+"\t"+"Train Name : "+search.getTrainName()+"\t"+"From : "+search1.getSource()
    						+"\t"+"To : "+search1.getDestination()+"\t"+"Price : "+search.getPrice());
    	System.out.println();
    	
    	//INSERTING A NEW TRAIN
    	Train train = new Train();
    	train.setTrainNo(1007);
    	train.setTrainName("Pandiyan Express");
    	train.setSource("Madurai");
    	train.setDestination("Chennai");
    	train.setPrice(850);
    	dao.insert(train);
    	System.out.println(train.toString());
    	System.out.println("1 row inserted.");
    	
    	Train train1 = new Train();
    	train1.setTrainNo(1008);
    	train1.setTrainName("Nellai Express");
    	train1.setSource("Tirunelveli");
    	train1.setDestination("Chennai");
    	train1.setPrice(900);
    	dao.insert(train1);
    	System.out.println(train1.toString());
    	System.out.println("2 row inserted");
    	
    	
    	((ClassPathXmlApplicationContext)ctx).close();
    }
}
